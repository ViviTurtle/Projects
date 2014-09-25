require 'openssl'
require_relative 'Encryptor'

e = Encryptor.new(ARGV[0], ARGV[1], ARGV[2])
e.encrypt()