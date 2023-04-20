CREATE TABLE public.person(
  id                SERIAL PRIMARY KEY NOT NULL,
  name              VARCHAR(250),
  gender            VARCHAR(100),
  age               INTEGER,
  identification    VARCHAR(10),
  address           VARCHAR(250),
  phone_number       VARCHAR(20)
);

CREATE TABLE public.client(
  id                SERIAL PRIMARY KEY NOT NULL REFERENCES person(id),
  password          VARCHAR(4),
  state             BOOLEAN
);

CREATE TABLE public.account(
  account_number VARCHAR(20) PRIMARY KEY NOT NULL,
  account_type VARCHAR(10),
  initial_balance FLOAT,
  state BOOLEAN,
  client_id SERIAL REFERENCES public.client(id)
);

CREATE TABLE public.movement(
  id SERIAL PRIMARY KEY NOT NULL,
  date TIMESTAMP,
  movement_type VARCHAR(10),
  amount FLOAT,
  balance FLOAT,
  account_number VARCHAR(20) REFERENCES public.account(account_number)
);