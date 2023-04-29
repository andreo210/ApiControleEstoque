
INSERT INTO controleestoque.pais(codigo,nome)VALUES(55,"Brasil");
INSERT INTO controleestoque.pais(codigo,nome)VALUES(54,"Argentina");
INSERT INTO controleestoque.pais(codigo,nome)VALUES(53,"Venezuela");

INSERT INTO controleestoque.estado(uf,nome,pais_id)VALUES("SP","São Paulo",1);
INSERT INTO controleestoque.estado(uf,nome,pais_id)VALUES("RJ","Rio de Janeiro",1);
INSERT INTO controleestoque.estado(uf,nome,pais_id)VALUES("MG","Minas Gerais",1);
INSERT INTO controleestoque.estado(uf,nome,pais_id)VALUES("RS","Rio Grande do Sul",1);

INSERT INTO controleestoque.cidade(nome,estado_id)VALUES("Santos",1);
INSERT INTO controleestoque.cidade(nome,estado_id)VALUES("Sorocaba",1);
INSERT INTO controleestoque.cidade(nome,estado_id)VALUES("Praia Grande",1);
INSERT INTO controleestoque.cidade(nome,estado_id)VALUES("Riberão Preto",1);