# Use the official MySQL image from Docker Hub
FROM mysql:latest

# Set environment variables for MySQL
ENV MYSQL_ROOT_PASSWORD=rootRoot@123
ENV MYSQL_DATABASE=phonebook
ENV MYSQL_USER=rootRoot@123
ENV MYSQL_PASSWORD=Root@123

# Expose the MySQL port
EXPOSE 3306