require 'openssl'
require_relative 'Decryptor'

d = Decryptor.new(ARGV[0], ARGV[1])
d.read()