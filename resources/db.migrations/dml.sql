START TRANSACTION;

-- Вставка даних в таблицю users
INSERT INTO public.users (username, user_tag, location, subscription_type)
VALUES ('JohnDoe', 'johndoe123', 'New York', 'Basic'),
       ('JaneSmith', 'janesmith456', 'London', 'Premium'),
       ('AliceJohnson', 'alicejohnson789', 'Paris', 'Basic');

-- Вставка даних в таблицю search_history
INSERT INTO public.search_history (user_id, weather_condition, date, temperature, humidity, windspeed, search_location)
VALUES (1, 'Sunny', '2023-05-01', '25°C', '50%', '10 mph', 'New York'),
       (1, 'Cloudy', '2023-05-02', '22°C', '60%', '8 mph', 'New York'),
       (2, 'Rainy', '2023-05-01', '18°C', '75%', '12 mph', 'London');

-- Вставка даних в таблицю blacklisted_users
INSERT INTO public.blacklisted_users (user_id, username, blacklisting_time, blacklisting_reason)
VALUES (3, 'AliceJohnson', '2023-05-03 10:30:00', 'Violation of terms'),
       (2, 'JaneSmith', '2023-05-04 14:45:00', 'Unauthorized access');

-- Вставка даних в таблицю premium_users
INSERT INTO public.premium_users (user_id, username, subscription_time, subscription_available_by)
VALUES (2, 'JaneSmith', '2023-05-01 09:00:00', '2024-05-01'),
       (3, 'AliceJohnson', '2023-05-02 15:20:00', '2024-05-02');

-- Вставка даних в таблицю reminders
INSERT INTO public.reminders (reminder_id, premium_user_id, reminder_time, reminder_type)
VALUES (1, 2, '2023-05-05 10:00:00', 'Appointment'),
       (2, 2, '2023-05-06 16:30:00', 'Payment');

-- Вставка даних в таблицю natural_disasters
INSERT INTO public.natural_disasters (premium_user_id, disaster_type, disaster_time, location, disaster_description)
VALUES (3, 'Earthquake', '2023-05-07 08:15:00', 'Paris', 'Magnitude 5.2 earthquake'),
       (3, 'Flood', '2023-05-08 12:45:00', 'Paris', 'Heavy rainfall causing flooding');

COMMIT;