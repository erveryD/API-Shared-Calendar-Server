create schema schedule collate utf8mb4_bin;

CREATE USER 'api_admin'@'%' IDENTIFIED BY 'rootroot';
GRANT ALL PRIVILEGES ON *.* TO 'api_admin'@'%';
FLUSH PRIVILEGES;