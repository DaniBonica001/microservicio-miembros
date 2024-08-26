CREATE TABLE members (
                         memberId BIGINT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(255),
                         email VARCHAR(255),
                         phoneNumber VARCHAR(255),
                         active BOOLEAN,
                         enrollmentDate DATE
);