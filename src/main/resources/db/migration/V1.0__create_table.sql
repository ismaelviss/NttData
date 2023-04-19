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