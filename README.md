# Minibank
Develop an API to open current accounts for existing customers. It provides an endpoint accepting customerID and initialCredit; it opens an account linked to customerID, and if initialCredit > 0, performs a transaction. Another endpoint displays user info: Name, Surname, balance, and transactions. 

### For development 
adding gradle plugin in eclipse -> buildship gradle integration 

addding lombok for eclipse -> help -> install new software -> work with -> https://projectlombok.org/p2 -> install -> restart 

adding mapstruct to the project -> in build.gradle add-> then run this command on root folder ->close eclipse -> gradlew eclipseJdtApt eclipseFactorypath eclipseJdt

-> right click on build.gradle and refresh

plugins {
    id 'com.diffplug.eclipse.apt' version '3.37.2'
}
