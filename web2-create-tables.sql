CREATE TABLE IF NOT EXISTS curso (
  id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
  nome VARCHAR(255) NOT NULL,
  link VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS aluno (
  id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
  nome VARCHAR(255) NOT NULL,
  cpf VARCHAR(14) NOT NULL UNIQUE,
  email VARCHAR(255) NOT NULL,
  nascimento DATE NOT NULL
);

CREATE TABLE IF NOT EXISTS matricula (
  id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
  aluno_id INTEGER NOT NULL,
  curso_id INTEGER NOT NULL,
  data_matricula DATE NOT NULL,
  nota DOUBLE PRECISION NOT NULL,
  CONSTRAINT fk_matricula_aluno
    FOREIGN KEY (aluno_id)
    REFERENCES aluno(id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT fk_matricula_curso
    FOREIGN KEY (curso_id)
    REFERENCES curso(id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);
