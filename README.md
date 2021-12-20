# Search REST API Demo

## Considerations

> :warning: Previously I have never before used elastic search. Therefore I had difficulties with the learning curve of the tool. I consider that documentation found is not the best for a first-time user.

> :warning: As I was not able to implement the ElasticSearch functionality I added the skeleton class to be transparent to the implementation. With correct training and information it would be straight forward to add this feature to the program with almost no modification as following the Open/Closed from SOLID principles.

> :warning: To be able to develop the rest of the functionalities I created a simple CSV file search framework to emulate the features from ElasticSearch, obviosuly this is just for demonstrations purposes and it is way more ineficient compared with speed and robustness from ElasticSearch.

## Requirements

* Java 1.8+
* Maven 3.6.0+

## Execution Instructions

### Build the code
1. Usually Maven installation from packages manager such as in Ubuntu distributions comes preconfigured for Java 1.8. Set required environment variable.

```bash
export JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64/
```
2. Build the code in target package mode with:

```bash
mvn clean package
```
### Run the app
1. Run the REST Java application with:

```bash
java -jar target/demo-1.0.0.jar
```

### Use the WebUI
1. Open your browser and put the following address:

```bash
http://localhost:8080/
```

Review examples of how to use each feature in the following section.

## Requirements Verification

### Requirement A
Search a title by name

![Requirement A](./rsrc/imgs/req_a.gif?raw=true "Requirement A Example Usage")

### Requirement B-C
1. The count of all titles grouped by rate, using the following ranges:
i. All above
ii. [6-8[
iii. [4-6[
iv. [2-4[
v. All below

2. All titles of a given genre in a particular rate range from the previous step (i.e. all dramas
where the rate is between 6 and 8).

![Requirement BC](./rsrc/imgs/req_a.gif?raw=true "Requirement B-C Example Usage")

### Requirement D
Add a “Did you mean?” feature in the endpoint created in step a.

![Requirement D](./rsrc/imgs/req_a.gif?raw=true "Requirement D Example Usage")

### Requirement E
Optional search parameters. What happens if you want to query only but range no matter the rate?

![Requirement E](./rsrc/imgs/req_e.gif?raw=true "Requirement E Example Usage")


## Autor
Fabian Solano Madriz <fasm2296@gmail.com>
Computer Engineer.
2021.