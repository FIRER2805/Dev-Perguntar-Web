-- Populando a tabela 'usuario'
INSERT INTO usuario (nome, e_mail, senha) VALUES
    ('Alex Silva', 'alex.silva@email.com', 'senha123'),
    ('Beatriz Lima', 'beatriz.lima@email.com', 'senha456'),
    ('Carlos Oliveira', 'carlos.oliveira@email.com', 'senha789');

-- Populando a tabela 'categoria'
INSERT INTO categoria (nome) VALUES
    ('Duvida geral'),
    ('Web Design'),
    ('Desenvolvimento Mobile');

-- Populando a tabela 'pergunta'
INSERT INTO pergunta (titulo, conteudo, data_pergunta, id_usuario, id_categoria) VALUES
    ('Como resolver um erro de compilação em Java?', 'Conteúdo da Pergunta 1', '2023-01-15 12:30:00', 1, 1),
    ('Melhores práticas para otimizar um site em WordPress', 'Conteúdo da Pergunta 2', '2023-02-20 08:45:00', 2, 2),
    ('Dicas para desenvolver aplicativos mobile responsivos', 'Conteúdo da Pergunta 3', '2023-03-05 16:20:00', 3, 3);

-- Populando a tabela 'resposta'
INSERT INTO resposta (conteudo, solucao, id_pergunta, id_usuario) VALUES
    ('Resposta 1 para Pergunta 1', 0, 1, 2),
    ('Resposta 2 para Pergunta 1', 0, 1, 3),
    ('Resposta 1 para Pergunta 2', 0, 2, 1),
    ('Resposta 1 para Pergunta 3', 0, 3, 2);

-- Populando a tabela 'usuario'
INSERT INTO usuario (nome, e_mail, senha) VALUES
    ('Daniel Pereira', 'daniel.pereira@email.com', 'senha123'),
    ('Elaine Santos', 'elaine.santos@email.com', 'senha456'),
    ('Fernando Martins', 'fernando.martins@email.com', 'senha789');

-- Populando a tabela 'categoria'
INSERT INTO categoria (nome) VALUES
    ('Desenvolvimento Web'),
    ('Segurança da Informação'),
    ('Inteligência Artificial');

-- Populando a tabela 'pergunta'
INSERT INTO pergunta (titulo, conteudo, data_pergunta, id_usuario, id_categoria) VALUES
    ('Como escolher o melhor framework para desenvolvimento web?', 'Conteúdo da Pergunta 4', '2023-04-10 09:15:00', 4, 4),
    ('Desafios de segurança em aplicações IoT', 'Conteúdo da Pergunta 5', '2023-05-25 14:00:00', 5, 5),
    ('Novidades e tendências em inteligência artificial', 'Conteúdo da Pergunta 6', '2023-06-30 18:45:00', 6, 6);

-- Populando a tabela 'resposta'
INSERT INTO resposta (conteudo, solucao, id_pergunta, id_usuario) VALUES
    ('Resposta 1 para Pergunta 4', 0, 4, 5),
    ('Resposta 2 para Pergunta 4', 0, 4, 6),
    ('Resposta 1 para Pergunta 5', 0, 5, 4),
    ('Resposta 1 para Pergunta 6', 0, 6, 5);

-- Populando a tabela 'usuario'
INSERT INTO usuario (nome, e_mail, senha) VALUES
    ('Gabriela Oliveira', 'gabriela.oliveira@email.com', 'senha123'),
    ('Hugo Almeida', 'hugo.almeida@email.com', 'senha456'),
    ('Isabela Souza', 'isabela.souza@email.com', 'senha789');

-- Populando a tabela 'categoria'
INSERT INTO categoria (nome) VALUES
    ('Segurança em Desenvolvimento Web'),
    ('Controle de Versão'),
    ('Desenvolvimento de Chatbots');

-- Populando a tabela 'pergunta'
INSERT INTO pergunta (titulo, conteudo, data_pergunta, id_usuario, id_categoria) VALUES
    ('Como evitar vulnerabilidades em aplicações web?', 'Conteúdo da Pergunta 7', '2023-07-12 11:30:00', 7, 7),
    ('A importância do versionamento de código com Git', 'Conteúdo da Pergunta 8', '2023-08-18 17:05:00', 8, 8),
    ('Desenvolvimento de chatbots: ferramentas e boas práticas', 'Conteúdo da Pergunta 9', '2023-09-23 22:40:00', 9, 9);

-- Populando a tabela 'resposta'
INSERT INTO resposta (conteudo, solucao, id_pergunta, id_usuario) VALUES
    ('Resposta 1 para Pergunta 7', 0, 7, 8),
    ('Resposta 2 para Pergunta 7', 0, 7, 9),
    ('Resposta 1 para Pergunta 8', 0, 8, 7),
    ('Resposta 1 para Pergunta 9', 0, 9, 8);

-- Populando a tabela 'usuario'
INSERT INTO usuario (nome, e_mail, senha) VALUES
    ('João Silva', 'joao.silva@email.com', 'senha123'),
    ('Kelly Costa', 'kelly.costa@email.com', 'senha456'),
    ('Lucas Alves', 'lucas.alves@email.com', 'senha789');

-- Populando a tabela 'categoria'
INSERT INTO categoria (nome) VALUES
    ('Desenvolvimento Cross-Platform'),
    ('SEO em Desenvolvimento Web'),
    ('Projetos de Machine Learning');

-- Populando a tabela 'pergunta'
INSERT INTO pergunta (titulo, conteudo, data_pergunta, id_usuario, id_categoria) VALUES
    ('Desenvolvimento de aplicações cross-platform com Flutter', 'Conteúdo da Pergunta 10', '2023-10-05 10:55:00', 10, 10),
    ('Melhores práticas para SEO em sites', 'Conteúdo da Pergunta 11', '2023-11-15 15:25:00', 11, 11),
    ('Desafios em projetos de machine learning', 'Conteúdo da Pergunta 12', '2023-11-20 20:10:00', 12, 12);

-- Populando a tabela 'resposta'
INSERT INTO resposta (conteudo, solucao, id_pergunta, id_usuario) VALUES
    ('Resposta 1 para Pergunta 10', 0, 10, 11),
    ('Resposta 2 para Pergunta 10', 0, 10, 12),
    ('Resposta 1 para Pergunta 11', 0, 11, 10),
    ('Resposta 1 para Pergunta 12', 0, 12, 11);
