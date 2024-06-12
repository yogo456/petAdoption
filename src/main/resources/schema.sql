-- Table for pet types
CREATE TABLE pet_type (
                           id INT AUTO_INCREMENT PRIMARY KEY,
                           type VARCHAR(50) NOT NULL
);

-- Insert initial pet types
INSERT INTO pet_type (type) VALUES
                                 ('Dog'),
                                 ('Cat'),
                                 ('Bird'),
                                 ('Rabbit'),
                                 ('Fish'),
                                 ('Reptile'),
                                 ('Other');

-- Table for users
CREATE TABLE user (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       first_name VARCHAR(100),
                       last_name VARCHAR(100),
                       email VARCHAR(100) NOT NULL UNIQUE,
                       password VARCHAR(100) NOT NULL,
                       phone VARCHAR(20),
                       address VARCHAR(255)
);

-- Table for pets
CREATE TABLE pet (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      owner_id BIGINT NOT NULL,
                      name VARCHAR(100) NOT NULL,
                      image LONGBLOB,
                      description TEXT NOT NULL,
                      birth_date DATE NOT NULL,
                      type_id INT NOT NULL,
                      FOREIGN KEY (owner_id) REFERENCES user(id),
                      FOREIGN KEY (type_id) REFERENCES pet_type(id)
);
