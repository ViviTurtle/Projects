##
#Encrypt - Encrypts plaintext
#
#Usage: ruby Encrypt.rb <authtoken> <logfilename> <line_to_encrypt>
##

require 'openssl'
#require '/path/to/Decrypt"	#TODO take care of this when we decide on final locations

require_relative 'Decryptor'

class Encryptor
	
	attr_accessor :authtoken, :logfilename, :line_to_encrypt, :encipher, :decipher

	#Constructor - holds the 3 arguments, sets up the cipher
	def initialize(token, log, line)
		
		self.authtoken			= OpenSSL::Digest::SHA256.new(token).to_s()
		self.logfilename		= log
		self.line_to_encrypt	= line

		self.encipher	= self.cryptosetup("encrypt")
	end

	#Set up the crypto
	#mode = (encrypt|decrypt) to select which mode
	def cryptosetup(mode)
		cipher = OpenSSL::Cipher::AES256.new('CBC')	#Choose AES-256 in CBC mode
		
		if (mode == "encrypt") then
			cipher.encrypt				#Set to encrypt mode
		else
			cipher.decrypt
		end

		return cipher
	end
	
	#Set up a file with salt, hash, IV. Executed when writing to file that
	#doesn't exist
	#
	#salt = sha256(timestamp)
	#hash = sha256(salt + authtoken)
	#iv = random_iv()
	def filesetup()
		
		salt	= OpenSSL::Digest::SHA256.new(Time.now().to_i().to_s())
		hash	= OpenSSL::Digest::SHA256.new(salt.to_s()+self.authtoken)
		iv		= self.encipher.random_iv()
		
#		if File.exist?(self.logfilename) then
#			$stderr.puts "#{self.logfilename} already exists! No need to filesetup()"
#			$stdout.puts("Fail")
#			exit(-2)
#		end
		
		f = File.open(self.logfilename, "wb")	#Open new file - wipes old one.
		f.write(salt.to_s + hash.to_s + iv)
		f.close()
	end

	#Check that the key/authtoken is correct
	#This should be done before attempting to encrypt a file
	def token_authenticator()
		
		#Ok, since each file can have its own key, the hash of the key should be
		#written to the file, possibly at the beginning with the IV.

		f = File.open(self.logfilename, "rb")
		salt = f.read(64)
		hash = f.read(64)
		f.close()
		digest = OpenSSL::Digest::SHA256.new(salt + self.authtoken)	#A lame way to salt, but...

		#TODO compare the hashes, make sure they match.
		#TODO we don't need to write the error to the file, do we?  How can we?
		#Java needs to be able to detect this and return -1 if fail!
		if (digest.to_s != hash) then
			$stderr.puts "Incorrect authentication token!"
			$stdout.puts("Fail:Authentication")
			exit(-1)
		end
	end

	#Write encrypted text
	#Takes plaintext it was initialized with, writes it to a file
	def encrypt()
		
		#If the file exists, get the plaintext from it, append, then write new file.
		#If it doesn't exist, just create the new file and write.
#		if (File.exist?(self.logfilename)) then
#			decryptor = Decryptor.new(ARGV[0], ARGV[1])
#			plaintext = decryptor.decrypt()
#			self.line_to_encrypt = plaintext + self.line_to_encrypt
#		end
		
		#If the file doesn't exist, just start here.
		self.filesetup()

		self.token_authenticator()
		file = File.open(self.logfilename, 'ab+')	#Now open file for append

		#Encrypt the plaintext, then write it to the file.
		self.encipher.key = self.authtoken
		file.read(64+64) #Read past the salt and hash
		self.encipher.iv = file.read(16) #16 byte iv
		ciphertext = self.encipher.update(self.line_to_encrypt) + self.encipher.final
		file.write(ciphertext)
		file.close()
	end
end