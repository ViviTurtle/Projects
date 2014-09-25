##
#Decrypt - Decrypts encrypted log files
#
#Usage: ruby Decrypt.rb <authtoken> <logfilename>
##

require 'openssl'

class Decryptor
	
	attr_accessor :authtoken, :logfilename, :decipher
	
	#Constructor - holds the 3 arguments, sets up the cipher
	def initialize(token, log)
		
		self.authtoken			= OpenSSL::Digest::SHA256.new(token).to_s()
		self.logfilename		= log
		
		self.decipher	= self.cryptosetup("decrypt")
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

	#Decrypt an encrypted file
	def decrypt()
			
		#Check if the file exists.  If not, fail.
		if (!File.exist?(self.logfilename)) then
			$stderr.puts("#{self.logfilename} does not exist.")
			$stdout.puts("Fail:File")
			exit(-1)
		end

		#Authenticate. If password correct, proceed.
		self.token_authenticator()
		file = File.open(self.logfilename, 'rb')

		#Decrypt the file.
		self.decipher.key = self.authtoken
		file.read(64+64)					#Read past the salt and hash
		self.decipher.iv = file.read(16)	#16-byte IV
		
		ciphertext = file.read()
		file.close()
		
		plaintext = self.decipher.update(ciphertext) + self.decipher.final
		
		return plaintext
	end
	
	#Read the decrypted text
	def read()
		$stdout.puts(self.decrypt())
	end
end