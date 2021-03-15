### VARIABLES ###

JC = javac
JCFLAGS = -encoding UTF-8 -implicit:none

JVM = java
JVMFLAGS = 

### REGLES ESSENTIELLES ###

Main.class : Main.java Menu.class Actionmenu.class Grille.class Image.class TabAlea.class RecupFichier.class TabChoix.class Superposition.class
	${JC} ${JCFLAGS} Main.java

Menu.class : Menu.java Actionmenu.class TabAlea.class
	${JC} ${JCFLAGS} Menu.java

Actionmenu.class : Actionmenu.java
	${JC} ${JCFLAGS} Actionmenu.java

TabAlea.class : TabAlea.java
	${JC} ${JCFLAGS} TabAlea.java

Grille.class : Grille.java Actionmenu.class Superposition.class
	${JC} ${JCFLAGS} Grille.java

Image.class : Image.java
	${JC} ${JCFLAGS} Image.java

RecupFichier.class : RecupFichier.java
	${JC} ${JCFLAGS} RecupFichier.java

TabChoix.class : TabChoix.java
	${JC} ${JCFLAGS} TabChoix.java

Superposition.class : Superposition.java
	${JC} ${JCFLAGS} Superposition.java


### REGLES OPTIONNELLES ###

run : Main.class
	${JVM} ${JVMFLAGS} Main

clean :
	-rm -f *.class

mrproper : clean Main.class

### BUTS FACTICES ###

.PHONY : run clean mrproper

### FIN ###