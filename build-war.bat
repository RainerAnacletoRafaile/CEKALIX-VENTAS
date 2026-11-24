@echo off
setlocal
if "%TOMCAT_HOME%"=="" set "TOMCAT_HOME=C:\dev\servers\apache-tomcat-11.0.29"
set "MYSQL_JAR=src\main\webapp\WEB-INF\lib\mysql-connector-j-9.5.0.jar"
if "%JAVA_HOME%"=="" (echo ERROR: Configura JAVA_HOME para JDK 17.& exit /b 1)
if not exist "%TOMCAT_HOME%\lib\servlet-api.jar" (echo ERROR: No se encuentra servlet-api.jar. Configura TOMCAT_HOME.& exit /b 1)
if not exist "%MYSQL_JAR%" (echo ERROR: Falta %MYSQL_JAR%. Descarga MySQL Connector/J 9.5.0 y copialo en WEB-INF\lib.& exit /b 1)
if exist build rmdir /s /q build
mkdir build\classes
mkdir build\war
xcopy src\main\webapp build\war /E /I /Q /Y >nul
dir /s /b src\main\java\*.java > build\sources.txt
"%JAVA_HOME%\bin\javac.exe" --release 17 -encoding UTF-8 -cp "%TOMCAT_HOME%\lib\servlet-api.jar;%MYSQL_JAR%" -d build\classes @build\sources.txt
if errorlevel 1 exit /b 1
if not exist build\war\WEB-INF\classes mkdir build\war\WEB-INF\classes
xcopy build\classes build\war\WEB-INF\classes /E /I /Q /Y >nul
"%JAVA_HOME%\bin\jar.exe" --create --file build\CEKALIX-VENTAS.war -C build\war .
if errorlevel 1 exit /b 1
echo WAR generado: build\CEKALIX-VENTAS.war
endlocal
