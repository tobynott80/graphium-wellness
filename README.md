# Graphium Wellbeing Portal

> No sensitive data is stored in this repository - only fictional employee data

### Running the Project


1. Clone the repository
2. Run the [init.sql](https://git.cardiff.ac.uk/c21048229/ase-2022-y2-team-07/-/wikis/uploads/f55ab506782c038a06d890d840be8612/init.sql) script in MariaDB to initialise the database credentials and create the schema
3. Run `./gradlew build` to build the project
4. Run the generated jar file in the build/libs folder
   * `java -jar build/libs/ase-2022-y2-team-07-{version}-SNAPSHOT.jar --PROD_PASSWORD=cardiff`
   * Note: it is important to include the PROD_PASSWORD environment variable - this provides the password to the database.
   * this can also be added by setting the environment variable in powershell
      - `$Env:PROD_PASSWORD = "cardiff"`

### Default Test Credentials

#### Employees
Email : {Name}@gmail.com

e.g `john@gmail.com`

Password : 1

#### Supervisors
Email : {Name}@gmail.com

e.g `carl@gmail.com`

Password : 1


