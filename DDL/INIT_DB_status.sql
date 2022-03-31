SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS m_status_info;
DROP TABLE IF EXISTS m_status_content_info;
DROP TABLE IF EXISTS m_status_content_like_info;


CREATE TABLE m_status_info(
    page_id BIGINT,
    status_id BIGINT,
    owner_id BIGINT,
    status_type char(1),
    block_flag char(1),
    del_flag char(1),
    block_cause_id INT,
    block_at TIMESTAMP,
    create_at TIMESTAMP,
    update_at TIMESTAMP,
    del_at TIMESTAMP,
    PRIMARY KEY(page_id, status_id)
);

CREATE TABLE m_status_content_info(
    page_id BIGINT,
    status_id BIGINT,
    content_id INT,
    content_type char(1),
    content_text VARCHAR(2000),
    content_uri VARCHAR(255),
    PRIMARY KEY(page_id, status_id, content_id)
);

CREATE TABLE m_status_content_like_info(
    page_id BIGINT,
    status_id BIGINT,
    content_id INT,
    user_id BIGINT,
    create_at TIMESTAMP,
    PRIMARY KEY(page_id, status_id, content_id, user_id)
);

ALTER TABLE m_status_info ADD CONSTRAINT m_status_info_page_fk
    FOREIGN KEY (page_id) REFERENCES m_page_info(page_id);

ALTER TABLE m_status_info ADD CONSTRAINT m_status_info_owner_fk
    FOREIGN KEY(owner_id) REFERENCES m_user_info(user_id);

ALTER TABLE m_status_content_info ADD CONSTRAINT m_status_content_info_status_fk
    FOREIGN KEY(page_id, status_id) REFERENCES m_status_info(page_id, status_id);

ALTER TABLE m_status_content_like_info ADD CONSTRAINT m_status_content_like_info_status_content_fk
    FOREIGN KEY(page_id, status_id, content_id) REFERENCES m_status_content_info(page_id, status_id, content_id);

ALTER TABLE m_status_content_like_info ADD CONSTRAINT m_status_content_like_info_user_fk
    FOREIGN KEY(user_id) REFERENCES m_user_info(user_id);