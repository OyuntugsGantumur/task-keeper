JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
		$(JC) $(JFLAGS) $*.java

CLASSES = \
		Controller.java \
		List.java \
		ListTag.java \
		Model.java \
		Node.java \
		TagNode.java \
		Main.java \
		Viewer.java \

default: classes

classes: $(CLASSES:.java=.class)

run: classes
	$(JVM) $(MAIN)

clean:
		$(RM) *.class
