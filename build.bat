cd C:\Users\louis\Desktop\sp
javac -d bin -cp bin;graphics.jar .\src\main\java\TowerDefense.java .\src\main\java\Base.java .\src\main\java\Tower.java
cd bin
jar cvfm TowerDefense.jar META-INF\MANIFEST.MF .\src\main\java\*.class
exit