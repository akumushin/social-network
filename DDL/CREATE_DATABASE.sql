-- CREATE DATABASE IF NOT EXISTS social_network_db;
CREATE USER social IDENTIFIED BY 'social4321';
GRANT ALL PRIVILEGES ON social_network_db.* TO social;