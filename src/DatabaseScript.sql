CREATE DATABASE EventManagement;
USE EventManagement;

-- =========================
-- ORGANIZER TABLE
-- =========================
CREATE TABLE organizers (
                            organizer_id INT AUTO_INCREMENT PRIMARY KEY,
                            name VARCHAR(100) NOT NULL,
                            email VARCHAR(100) NOT NULL
);

-- =========================
-- PARTICIPANT TABLE
-- =========================
CREATE TABLE participants (
                              participant_id INT AUTO_INCREMENT PRIMARY KEY,
                              name VARCHAR(100) NOT NULL,
                              email VARCHAR(100) NOT NULL
);

-- =========================
-- EVENTS TABLE (with subclasses)
-- =========================
CREATE TABLE events (
                        event_id INT AUTO_INCREMENT PRIMARY KEY,
                        name VARCHAR(100) NOT NULL,
                        date DATE,
                        max_participants INT,
                        organizer_id INT,

                        event_type VARCHAR(50), -- Professional, Social, Academic, etc.

    -- subclass fields
                        subject VARCHAR(100),
                        industry VARCHAR(100),
                        theme VARCHAR(100),
                        speaker VARCHAR(100),

                        FOREIGN KEY (organizer_id) REFERENCES organizers(organizer_id)
                            ON DELETE SET NULL
);

-- =========================
-- REGISTRATION TABLE
-- =========================
CREATE TABLE registrations (
                               registration_id INT AUTO_INCREMENT PRIMARY KEY,
                               event_id INT,
                               participant_id INT,
                               registration_date DATE,

                               FOREIGN KEY (event_id) REFERENCES events(event_id)
                                   ON DELETE CASCADE,

                               FOREIGN KEY (participant_id) REFERENCES participants(participant_id)
                                   ON DELETE CASCADE
);