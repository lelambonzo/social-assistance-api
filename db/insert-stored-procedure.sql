DELIMITER //

CREATE PROCEDURE InsertApplicant(
    IN app_date DATE,
    IN f_name VARCHAR(50),
    IN m_name VARCHAR(50),
    IN l_name VARCHAR(50),
    IN sex INT,
    IN age INT,
    IN marital_status INT,
    IN id_passport VARCHAR(20),
    IN village INT,
    IN postal VARCHAR(255),
    IN physical VARCHAR(255),
    IN telephone VARCHAR(50),
    IN declaration BOOLEAN
)
BEGIN
    INSERT INTO applicants (
        application_date, first_name, middle_name, last_name, sex_id,
        age, marital_status_id, id_passport_number, village_id,
        postal_address, physical_address, telephone_contacts, declaration
    )
    VALUES (
        app_date, f_name, m_name, l_name, sex, age, marital_status,
        id_passport, village, postal, physical, telephone, declaration
    );
END //

DELIMITER ;
