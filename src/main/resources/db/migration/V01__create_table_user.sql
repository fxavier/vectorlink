CREATE TABLE usuario (
    codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    senha VARCHAR(120) NOT NULL,
    ativo BOOLEAN DEFAULT true
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE grupo (
    codigo BIGINT(20) PRIMARY KEY,
    nome VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE permissao (
    codigo BIGINT(20) PRIMARY KEY,
    nome VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE usuario_grupo (
    codigo_usuario BIGINT(20) NOT NULL,
    codigo_grupo BIGINT(20) NOT NULL,
    PRIMARY KEY (codigo_usuario, codigo_grupo),
    FOREIGN KEY (codigo_usuario) REFERENCES usuario(codigo),
    FOREIGN KEY (codigo_grupo) REFERENCES grupo(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE grupo_permissao (
    codigo_grupo BIGINT(20) NOT NULL,
    codigo_permissao BIGINT(20) NOT NULL,
    PRIMARY KEY (codigo_grupo, codigo_permissao),
    FOREIGN KEY (codigo_grupo) REFERENCES grupo(codigo),
    FOREIGN KEY (codigo_permissao) REFERENCES permissao(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO usuario VALUES('1', 'admin', 'admin@pmivectorlink.com', '$2a$10$fvMZAEn9LprgOqS7pBIdruwOdjc8trfEHy6eyBPYWYpt9/8dF51D.', '1');

INSERT INTO grupo VALUES(1,'Administrator');
INSERT INTO grupo VALUES(2,'M&E');
INSERT INTO grupo VALUES(3,'Data Clerk');
INSERT INTO grupo VALUES(4,'Operations');
INSERT INTO grupo VALUES(5,'ECO');
INSERT INTO grupo VALUES(6,'Logistics');
INSERT INTO grupo VALUES(7,'COP');

INSERT INTO permissao VALUES(1,'CADASTRAR_ACTORES');
INSERT INTO permissao VALUES(2,'CADASTRAR_GEOGRAFIA');   
INSERT INTO permissao VALUES(3,'CADASTRAR_MOBILIZACAO');
INSERT INTO permissao VALUES(4,'CADASTRAR_PULVERIZACAO');
INSERT INTO permissao VALUES(5,'CADASTRAR_ACTORES');

INSERT INTO permissao VALUES(6,'ACTUALIZAR_ACTORES');
INSERT INTO permissao VALUES(7,'ACTUALIZAR_GEOGRAFIA');   
INSERT INTO permissao VALUES(8,'ACTUALIZAR_MOBILIZACAO');
INSERT INTO permissao VALUES(9,'ACTUALIZAR_PULVERIZACAO');
INSERT INTO permissao VALUES(10,'ACTUALIZAR_ACTORES');


INSERT INTO permissao VALUES(11,'EXCLUIR_ACTORES');
INSERT INTO permissao VALUES(12,'EXCLUIR_GEOGRAFIA');   
INSERT INTO permissao VALUES(13,'EXCLUIR_MOBILIZACAO');
INSERT INTO permissao VALUES(14,'EXCLUIR_PULVERIZACAO');
INSERT INTO permissao VALUES(15,'EXCLUIR_ACTORES');
INSERT INTO permissao VALUES(16,'CADASTRAR_USUARIOS');

INSERT INTO usuario_grupo VALUES(1,1);

INSERT INTO grupo_permissao VALUES(1,1);
INSERT INTO grupo_permissao VALUES(1,2);
INSERT INTO grupo_permissao VALUES(1,3);
INSERT INTO grupo_permissao VALUES(1,4);
INSERT INTO grupo_permissao VALUES(1,5);
INSERT INTO grupo_permissao VALUES(1,6);
INSERT INTO grupo_permissao VALUES(1,7);
INSERT INTO grupo_permissao VALUES(1,8);
INSERT INTO grupo_permissao VALUES(1,9);
INSERT INTO grupo_permissao VALUES(1,10);
INSERT INTO grupo_permissao VALUES(1,11);
INSERT INTO grupo_permissao VALUES(1,12);
INSERT INTO grupo_permissao VALUES(1,13);
INSERT INTO grupo_permissao VALUES(1,14);
INSERT INTO grupo_permissao VALUES(1,15);
INSERT INTO grupo_permissao VALUES(1,16);


