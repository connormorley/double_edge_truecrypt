stringThing = 'nkaewurgb94bgqubo83ub4g825gb3un02ugtj92p58jt209p58yj2495gnh0g92d'
bytesThing = stringThing.encode(encoding='UTF-8')
fh = open("C:\\Documents and Settings\\NetworkService\\Desktop\\256845235785", "r+b")
fh.seek(0)
fh.write(bytesThing)
fh.close()
