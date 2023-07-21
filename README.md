# Data Dictionary Generator

Data Dictionary Generator is a web application that allows you to generate a data dictionary from a database. This application is built using Java and Spring Boot, and it provides a user-friendly interface to extract and visualize the metadata of the database tables.

## How to Build and Run Using Docker

To build and run the Data Dictionary Generator application using Docker, follow the steps below:

1. Make sure you have Docker installed on your machine.

2. Clone the repository and navigate to the project directory:

```bash
git clone https://github.com/phaiEZ/data-dictionary-generator.git
cd data-dictionary-generator
```

3. Create a Docker image for the application by running the following command:

```bash
docker build -t data-dictionary-app .
```

4. Once the Docker image is created, you can run the Data Dictionary Generator application as a Docker container using the following command:

```bash
docker run -p 8080:8080 data-dictionary-app
```

5. The application will now be running inside the Docker container, and you can access it in your web browser by navigating to `http://localhost:8080`.

## Usage

1. Access the Data Dictionary Generator application in your web browser at `http://localhost:8080`.

2. Connect to your desired database by providing the necessary credentials (e.g., database URL, username, password).

3. Select the database schema and tables for which you want to generate the data dictionary.

4. Click on the "Generate Data Dictionary" button to initiate the process.

5. The application will extract the metadata from the selected tables and display the data dictionary, including information such as column names, data types, constraints, and descriptions.

6. You can then save the data dictionary as a downloadable file for future reference.

## Contributor

- 
- 
- Tunyarat Nitihirunpattana

Feel free to fork the repository, make improvements, and create a pull request. We welcome contributions from the open-source community.

