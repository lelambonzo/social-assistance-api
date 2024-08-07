DELIMITER //

CREATE PROCEDURE GetApplicantsByProgram(
    IN program_id INT
)
BEGIN
    SELECT a.first_name, a.middle_name, a.last_name, a.id_passport_number, sap.program_description
    FROM applicants a
    JOIN applicant_programs ap ON a.applicant_id = ap.applicant_id
    JOIN social_assistance_programs sap ON ap.program_id = sap.program_id
    WHERE sap.program_id = program_id;
END //

DELIMITER ;
