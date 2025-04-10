Here’s your step-by-step document to run your Spring Boot Maven application on Android using Termux. You can copy, save, or convert it to PDF for future reference.

* * *

Run Spring Boot Application on Android using Termux
===================================================

(Without Docker, Using Maven & Java 17)

Project: Student Management  
GitHub: [https://github.com/AKHIL8404/Studentmanagement](https://github.com/AKHIL8404/Studentmanagement)

* * *

1\. Prerequisites
-----------------

*   Termux app installed (latest version from F-Droid recommended)
    
*   ZIP of your Spring Boot project (extracted)
    
*   Cloud MySQL database credentials (host, database, username, password)
    
*   Internet connection
    

* * *

2\. Grant Storage Access to Termux
----------------------------------

Run this in Termux:

`termux-setup-storage` 

Accept the permission prompt. This creates a folder at:

bash

`~/storage/` 

* * *

3\. Move Project to Termux
--------------------------

Assuming your extracted folder is located at:

swift

`/storage/emulated/0/A1 Spring Boot/Studentmanagement-main` 

Copy it into Termux home:

`cd /storage/emulated/0/A1\ Spring\ Boot/ cp -r Studentmanagement-main ~/StudentManagement cd ~/StudentManagement` 

* * *

4\. Install Required Packages
-----------------------------

Install Java and Maven:

`pkg update && pkg upgrade
pkg install openjdk-17
pkg install maven` 

Verify:

`java -version
mvn -v` 

* * *

5\. Configure application.properties
------------------------------------

Open the config file:

`nano src/main/resources/application.properties` 

Update database config:

`spring.datasource.url=jdbc:mysql://your-cloud-db-url:3306/dbname
spring.datasource.username=yourUsername
spring.datasource.password=yourPassword
spring.jpa.hibernate.ddl-auto=update` 

Press CTRL + X → Y → Enter to save.

* * *

6\. Build the Project with Maven
--------------------------------

`mvn clean package -DskipTests` 

The output JAR will be generated at:

pgsql

`target/StudentManagement1-0.0.1-SNAPSHOT.jar` 

* * *

7\. Run the Spring Boot App
---------------------------

`java -jar target/StudentManagement1-0.0.1-SNAPSHOT.jar` 

You should see:

nginx

`Tomcat started on port 8080 Started StudentManagement1Application` 

* * *

8\. Access the Web App
----------------------

Option A – Terminal Browser:

`pkg install w3m
w3m http://localhost:8080` 

Option B – Expose to mobile browser using ngrok:

1.  Download ngrok:
    

`pkg install wget unzip
wget https://bin.equinox.io/c/bNyj1mQVY4c/ngrok-stable-linux-arm.zip
unzip ngrok-stable-linux-arm.zip chmod +x ngrok` 

2.  Set auth token:
    

`./ngrok config add-authtoken YOUR_AUTH_TOKEN` 

3.  Start tunnel:
    

`./ngrok http 8080` 

4.  Open the https:// URL shown in your browser.
    

* * *

Done!
-----

Your Spring Boot app is running on your Android device through Termux using Maven. You can now test APIs or access your frontend, all from your phone.

—

Let me know if you’d like this in PDF format or need an automation script to make this faster in the future.

![Export to Google Doc](chrome-extension://iapioliapockkkikccgbiaalfhoieano/assets/create.svg)![Copy with formatting](chrome-extension://iapioliapockkkikccgbiaalfhoieano/assets/copy.svg)![Select for Multi-select](chrome-extension://iapioliapockkkikccgbiaalfhoieano/assets/multi-select.svg)

2/2
