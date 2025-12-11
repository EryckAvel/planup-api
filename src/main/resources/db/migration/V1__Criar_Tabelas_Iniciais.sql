CREATE TABLE usuario (
  id_usuario SERIAL PRIMARY KEY,
  nome VARCHAR(150) NOT NULL,
  email VARCHAR(100) UNIQUE NOT NULL,
  senha VARCHAR(255) NOT NULL,
  ativo BOOLEAN NOT NULL DEFAULT TRUE,
  data_criacao TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_usuario_email ON usuario (email);

CREATE TABLE meta (
  id_meta SERIAL PRIMARY KEY,
  id_usuario INTEGER NOT NULL,
  nome_meta VARCHAR(200) NOT NULL,
  valor_estimado NUMERIC(12,2) NOT NULL,
  valor_gasto NUMERIC(12,2) DEFAULT 0,
  data_criacao TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  data_atualizacao TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE montante (
  id_montante SERIAL PRIMARY KEY,
  id_usuario INTEGER NOT NULL,
  saldo NUMERIC(12,2) NOT NULL DEFAULT 0,
  data_criacao TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  data_atualizacao TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE montante_historico (
  id_montante_historico SERIAL PRIMARY KEY,
  id_montante INTEGER NOT NULL,
  tipo_movimento VARCHAR(20) NOT NULL,
  valor_anterior NUMERIC(12,2) NOT NULL,
  valor_diferenca NUMERIC(12,2) NOT NULL,
  valor_atual NUMERIC(12,2) NOT NULL,
  data_criacao TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

ALTER TABLE meta ADD CONSTRAINT fk_meta_usuario
  FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario);

ALTER TABLE montante ADD CONSTRAINT fk_montante_usuario
  FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario);

ALTER TABLE montante_historico ADD CONSTRAINT fk_montante_historico_montante
  FOREIGN KEY (id_montante) REFERENCES montante (id_montante);