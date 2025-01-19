CREATE TABLE users (
                      id BIGSERIAL PRIMARY KEY,
                      username VARCHAR(80) NOT NULL,
                      email VARCHAR(120) NOT NULL UNIQUE
);

CREATE TABLE account (
                         id BIGSERIAL PRIMARY KEY,
                         user_id BIGINT REFERENCES users(id) ON DELETE CASCADE,
                         balance DOUBLE PRECISION DEFAULT 0
);
