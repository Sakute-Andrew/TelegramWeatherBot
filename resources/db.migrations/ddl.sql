START TRANSACTION;

CREATE SCHEMA IF NOT EXISTS public;

CREATE TABLE IF NOT EXISTS public.users
(
    users_id          SERIAL CONSTRAINT users_pk PRIMARY KEY,
    username          CHAR(50) NOT NULL,
    user_tag          CHAR(50) NOT NULL,
    location          CHAR(50) NOT NULL,
    subscription_type CHAR(50) NOT NULL
    );

ALTER TABLE public.users SET SCHEMA public;

CREATE TABLE IF NOT EXISTS public.search_history
(
    history_id        SERIAL CONSTRAINT search_history_pk PRIMARY KEY,
    user_id           INTEGER CONSTRAINT search_history_users_users_id_fk REFERENCES public.users,
    weather_condition CHAR(200) NOT NULL,
    date              DATE NOT NULL,
    temperature       CHAR(50) NOT NULL,
    humidity          CHAR(50) NOT NULL,
    windspeed         CHAR(50) NOT NULL,
    search_location   CHAR(50) NOT NULL
    );

ALTER TABLE public.search_history SET SCHEMA public;

CREATE TABLE IF NOT EXISTS public.blacklisted_users
(
    blacklisted_id      SERIAL CONSTRAINT blacklisted_users_pk PRIMARY KEY,
    user_id             INTEGER NOT NULL CONSTRAINT blacklisted_users_users_users_id_fk REFERENCES public.users,
    username            CHAR(50) NOT NULL,
    blacklisting_time   TIMESTAMP NOT NULL,
    blacklisting_reason CHAR(200) NOT NULL
    );

ALTER TABLE public.blacklisted_users SET SCHEMA public;

CREATE TABLE IF NOT EXISTS public.premium_users
(
    premium_user_id           SERIAL CONSTRAINT premium_users_pk PRIMARY KEY,
    user_id                   INTEGER NOT NULL CONSTRAINT premium_users_users_users_id_fk REFERENCES public.users,
    username                  CHAR(50) NOT NULL,
    subscription_time         TIMESTAMP NOT NULL,
    subscription_available_by DATE NOT NULL
);

ALTER TABLE public.premium_users SET SCHEMA public;

CREATE TABLE IF NOT EXISTS public.reminders
(
    reminder_id     INTEGER NOT NULL CONSTRAINT reminders_pk PRIMARY KEY,
    premium_user_id INTEGER CONSTRAINT reminders_premium_users_premium_user_id_fk REFERENCES public.premium_users,
    reminder_time   TIMESTAMP NOT NULL,
    reminder_type   CHAR(50) NOT NULL
    );

ALTER TABLE public.reminders SET SCHEMA public;

CREATE TABLE IF NOT EXISTS public.natural_disasters
(
    disaster_id          SERIAL CONSTRAINT natural_disasters_pk PRIMARY KEY,
    premium_user_id      INTEGER NOT NULL CONSTRAINT natural_disasters_premium_users_premium_user_id_fk REFERENCES public.premium_users,
    disaster_type        CHAR(50) NOT NULL,
    disaster_time        TIMESTAMP NOT NULL,
    location             CHAR(50) NOT NULL,
    disaster_description CHAR(50) NOT NULL
    );

ALTER TABLE public.natural_disasters SET SCHEMA public;

COMMIT;
