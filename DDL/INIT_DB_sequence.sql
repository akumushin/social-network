SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS m_sequence_info CASCADE;

CREATE TABLE m_sequence_info(
    sequence_id VARCHAR(10) PRIMARY KEY,
    current_num BIGINT NOT NULL,
    max_num BIGINT NOT NULL
);
