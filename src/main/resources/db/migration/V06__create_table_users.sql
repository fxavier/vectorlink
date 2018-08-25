CREATE TABLE users (
    codigo BIGSERIAL,
    nome VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    senha VARCHAR(120) NOT NULL,
    ativo BOOLEAN DEFAULT true,
    PRIMARY KEY(codigo)
);

CREATE TABLE grupo (
    codigo BIGSERIAL,
    nome VARCHAR(50) NOT NULL,
    PRIMARY KEY(codigo)
);

CREATE TABLE permissao (
    codigo BIGSERIAL,
    nome VARCHAR(50) NOT NULL,
    PRIMARY KEY(codigo)
);

CREATE TABLE usuario_grupo (
    codigo_usuario BIGINT NOT NULL,
    codigo_grupo BIGINT NOT NULL,
    PRIMARY KEY (codigo_usuario, codigo_grupo),
    CONSTRAINT fk_usuario_grupo
      FOREIGN KEY (codigo_usuario) REFERENCES users(codigo),
    CONSTRAINT fk_grupo_user  
      FOREIGN KEY (codigo_grupo) REFERENCES grupo(codigo)
);

CREATE TABLE grupo_permissao (
    codigo_grupo BIGINT NOT NULL,
    codigo_permissao BIGINT NOT NULL,
    PRIMARY KEY (codigo_grupo, codigo_permissao),
    CONSTRAINT fk_grupo_permissao
      FOREIGN KEY (codigo_grupo) REFERENCES grupo(codigo),
    CONSTRAINT fk_permissao_group  
      FOREIGN KEY (codigo_permissao) REFERENCES permissao(codigo)
);
