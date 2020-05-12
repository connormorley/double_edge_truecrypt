# double_edge_truecrypt
This is a basic little application that works by concaternating multiple passwords to generate the correct password for a TrueCrypt container. The fail safe element is that if the incorrect password is used X number of times, the TrueCrypt file is altered slightly making it irretrievable and unopenable by any means. 

# How it works
I wrote this a while ago so may be fuzzy. 

The program works by taking multiple passwords, hashhing them and splicing them together in a cascading function in order to generate a final password made up of 3 SHA1 hashes appended to each other. Simple but effective.

The fail safe elements works by keeping a basic file counter, on each unssuccessful entry the counter in incremented to a set value. On the set value, a secondary python script is executed which alters the TrueCrypt header of the container to dummy data from a corrupted container I made years ago. With this header, no container can ever open. 

# Reason for building

A really annoying puzzle for a final years forensics class I was in. 
