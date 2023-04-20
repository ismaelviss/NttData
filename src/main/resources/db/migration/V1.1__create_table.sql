CREATE TABLE public.person(
  id                SERIAL NOT NULL,
  name              VARCHAR(250) NOT NULL,
  gender            VARCHAR(100) NOT NULL,
  age               INTEGER NOT NULL,
  identification    VARCHAR(10) NOT NULL,
  address           VARCHAR(250) NOT NULL,
  phone_number       VARCHAR(20) NOT NULL,
  CONSTRAINT person_pkey PRIMARY KEY (id),
  CONSTRAINT person_constraint_1 UNIQUE (identification)
);

CREATE TABLE public.client(
  id                SERIAL NOT NULL,
  password          VARCHAR(4) NOT NULL,
  state             BOOLEAN NOT NULL,
  CONSTRAINT client_pkey PRIMARY KEY (id),
  CONSTRAINT client_constraint_1 FOREIGN KEY (id)
    REFERENCES public.person (id) MATCH SIMPLE
    ON DELETE CASCADE
);

CREATE TABLE public.account(
  account_number VARCHAR(20) NOT NULL,
  account_type VARCHAR(10) NOT NULL,
  initial_balance FLOAT NOT NULL,
  state BOOLEAN NOT NULL,
  client_id SERIAL NOT NULL,
  CONSTRAINT account_pkey PRIMARY KEY (account_number),
  CONSTRAINT account_constraint_1 FOREIGN KEY (client_id)
    REFERENCES public.client (id) MATCH SIMPLE
    ON DELETE CASCADE
);

CREATE TABLE public.movement(
  id SERIAL NOT NULL,
  date TIMESTAMP NOT NULL,
  movement_type VARCHAR(10) NOT NULL,
  amount FLOAT NOT NULL,
  balance FLOAT NOT NULL,
  account_number VARCHAR(20) NOT NULL,
  CONSTRAINT movement_pkey PRIMARY KEY (id),
  CONSTRAINT movement_constraint_1 FOREIGN KEY (account_number)
    REFERENCES public.account (account_number) MATCH SIMPLE
    ON DELETE CASCADE
);