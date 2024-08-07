CREATE TABLE applicants (
    applicant_id INT AUTO_INCREMENT PRIMARY KEY,
    application_date DATE NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    middle_name VARCHAR(50),
    last_name VARCHAR(50) NOT NULL,
    sex_id INT,
    age INT NOT NULL,
    marital_status_id INT,
    id_passport_number VARCHAR(20) NOT NULL,
    village_id INT,
    postal_address VARCHAR(255),
    physical_address VARCHAR(255),
    telephone_contacts VARCHAR(50),
    declaration BOOLEAN
);

CREATE TABLE sex (
    sex_id INT AUTO_INCREMENT PRIMARY KEY,
    sex_description VARCHAR(10) NOT NULL
);

CREATE TABLE marital_status (
    marital_status_id INT AUTO_INCREMENT PRIMARY KEY,
    marital_status_description VARCHAR(20) NOT NULL
);

CREATE TABLE county (
    county_id INT AUTO_INCREMENT PRIMARY KEY,
    county_name VARCHAR(100) NOT NULL
);

CREATE TABLE sub_county (
    sub_county_id INT AUTO_INCREMENT PRIMARY KEY,
    sub_county_name VARCHAR(100) NOT NULL,
    county_id INT
);

CREATE TABLE location (
    location_id INT AUTO_INCREMENT PRIMARY KEY,
    location_name VARCHAR(100) NOT NULL,
    sub_county_id INT
);

CREATE TABLE sub_location (
    sub_location_id INT AUTO_INCREMENT PRIMARY KEY,
    sub_location_name VARCHAR(100) NOT NULL,
    location_id INT
);

CREATE TABLE village (
    village_id INT AUTO_INCREMENT PRIMARY KEY,
    village_name VARCHAR(100) NOT NULL,
    sub_location_id INT
);

CREATE TABLE social_assistance_programs (
    program_id INT AUTO_INCREMENT PRIMARY KEY,
    program_description VARCHAR(100) NOT NULL
);

CREATE TABLE applicant_programs (
    applicant_program_id INT AUTO_INCREMENT PRIMARY KEY,
    applicant_id INT,
    program_id INT
);

ALTER TABLE applicants 
ADD FOREIGN KEY (sex_id) REFERENCES sex(sex_id);

ALTER TABLE applicants 
ADD FOREIGN KEY (marital_status_id) REFERENCES marital_status(marital_status_id);

ALTER TABLE applicants 
ADD FOREIGN KEY (village_id) REFERENCES village(village_id);

ALTER TABLE sub_county 
ADD FOREIGN KEY (county_id) REFERENCES county(county_id);

ALTER TABLE location 
ADD FOREIGN KEY (sub_county_id) REFERENCES sub_county(sub_county_id);

ALTER TABLE sub_location 
ADD FOREIGN KEY (location_id) REFERENCES location(location_id);

ALTER TABLE village 
ADD FOREIGN KEY (sub_location_id) REFERENCES sub_location(sub_location_id);

ALTER TABLE applicant_programs 
ADD FOREIGN KEY (applicant_id) REFERENCES applicants(applicant_id);

ALTER TABLE applicant_programs 
ADD FOREIGN KEY (program_id) REFERENCES social_assistance_programs(program_id);
