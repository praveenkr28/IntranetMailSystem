
  ** HOW TO RUN PROJECT  **
1.First of install Xampp(combined package for Tomcat,Apache and My-Sql) in C directory.
2.Start PhpMyAdmin.Create a database named Intranet.Import Intranet.sql file.It will create the necesarry tables.
	Username is root and password=""(ie blank) for phpmyadmin.
3.The folder of Intranet should be copied to folder webapps which is in tomcat folder in xampp folder in directory where xampp was installed.
 ie  "Directory where xampp was installed"/xampp/webapps/Intranet . 
4.Copy these API in lib folder of tomcat
	a> mysql-connector-java-5.0.8-bin.jar
	b> commons-fileupload-1.2.2.jar
	c> commons-io-2.3.jar
5. Add path of these files to ClassPath environment variable.
	Also add path of servlet-api.jar to classpath.
6. Copy folder "python" folder in xampp folder which i have used to store downloaded file .
8. Now Start Apache,MySql,Tomcat from Xampp Control Panel.
	Enter 127.0.0.1:8080/welcome.html
		Project will be running now.



//Git Initializtion

1. Create a new repository 
echo "# IntranetMailSystem" >> README.md
git init
git add README.md
git commit -m "first commit"
git remote add origin https://github.com/praveenkr28/IntranetMailSystem.git
git push -u origin master


