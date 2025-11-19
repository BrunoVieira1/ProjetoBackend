-- LIMPAR DADOS ANTERIORES (Opcional, bom para testes)
-- DELETE FROM chamado;
-- DELETE FROM cliente;
-- DELETE FROM tecnico;

-- POPULANDO TÉCNICOS
-- Senha '123' criptografada com BCrypt: $2a$10$c7uTJUhzzpfrJrpMLo1fvu/d1F5.f3b5.a/h.qXq1/u.I3b5.a
INSERT INTO tecnico (id, nome, cpf, email, senha, perfil_enum, data_criacao)
VALUES (1, 'Valdir Cezar', '123.456.789-00', 'valdir@mail.com', '$2a$10$c7uTJUhzzpfrJrpMLo1fvu/d1F5.f3b5.a/h.qXq1/u.I3b5.a', 'ADMIN', '2023-08-30');

INSERT INTO tecnico (id, nome, cpf, email, senha, perfil_enum, data_criacao)
VALUES (2, 'Richard Stallman', '234.567.890-11', 'richard@gnu.org', '$2a$10$c7uTJUhzzpfrJrpMLo1fvu/d1F5.f3b5.a/h.qXq1/u.I3b5.a', 'TECNICO', '2023-08-30');

INSERT INTO tecnico (id, nome, cpf, email, senha, perfil_enum, data_criacao)
VALUES (3, 'Claude Shannon', '345.678.901-22', 'claude@bit.com', '$2a$10$c7uTJUhzzpfrJrpMLo1fvu/d1F5.f3b5.a/h.qXq1/u.I3b5.a', 'TECNICO', '2023-08-30');


-- POPULANDO CLIENTES
INSERT INTO cliente (id, nome, cpf, email, senha, perfil_enum, data_criacao)
VALUES (1, 'Linus Torvalds', '456.789.012-33', 'linus@linux.com', '$2a$10$c7uTJUhzzpfrJrpMLo1fvu/d1F5.f3b5.a/h.qXq1/u.I3b5.a', 'CLIENTE', '2023-08-30');

INSERT INTO cliente (id, nome, cpf, email, senha, perfil_enum, data_criacao)
VALUES (2, 'Albert Einstein', '567.890.123-44', 'albert@relativity.com', '$2a$10$c7uTJUhzzpfrJrpMLo1fvu/d1F5.f3b5.a/h.qXq1/u.I3b5.a', 'CLIENTE', '2023-08-30');


-- POPULANDO CHAMADOS
-- Assumindo que os Enums são Strings: 'BAIXA', 'MEDIA', 'ALTA' e 'ABERTO', 'ANDAMENTO', 'ENCERRADO'
-- Chamado 1: Técnico Valdir (1) atendendo Cliente Linus (1)
INSERT INTO chamado (id, data_abertura, data_fechamento, prioridade, status, titulo, observacoes, tecnico_id, cliente_id)
VALUES (1, '2023-11-19', null, 'MEDIA', 'ANDAMENTO', 'Impressora pegando fogo', 'A impressora começou a soltar fumaça ao imprimir PDF.', 1, 1);

-- Chamado 2: Técnico Richard (2) atendendo Cliente Albert (2)
INSERT INTO chamado (id, data_abertura, data_fechamento, prioridade, status, titulo, observacoes, tecnico_id, cliente_id)
VALUES (2, '2023-11-18', '2023-11-19', 'ALTA', 'ENCERRADO', 'Tela Azul no Windows', 'Cliente relatou tela azul. Formatado e resolvido.', 2, 2);

-- Chamado 3: Técnico Valdir (1) atendendo Cliente Albert (2)
INSERT INTO chamado (id, data_abertura, data_fechamento, prioridade, status, titulo, observacoes, tecnico_id, cliente_id)
VALUES (3, '2023-11-20', null, 'BAIXA', 'ABERTO', 'Mouse falhando', 'Trocar pilha do mouse.', 1, 2);