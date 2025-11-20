INSERT INTO categoria (id_categoria, nombre) VALUES
(1, 'Computadores y Componentes'),
(2, 'Accesorios y Periféricos'),
(3, 'Audio y Video'),
(4, 'Electrodomésticos'),
(5, 'Hogar Inteligente'),
(6, 'Redes'),
(7, 'Gaming')
ON DUPLICATE KEY UPDATE id_categoria = id_categoria;

INSERT INTO producto (id_producto, nombre, descripcion, precio, stock, id_categoria) VALUES
(1, 'Laptop', 'Portátil con pantalla Full HD y SSD de 512GB', 89999, 10, 1),
(2, 'Smartphone', 'Teléfono con cámara de 108MP y carga rápida', 29999, 20, 1),
(3, 'Tablet', 'Dispositivo con pantalla táctil de 10 pulgadas', 24999, 15, 1),
(4, 'Auriculares', 'Audífonos inalámbricos con cancelación de ruido', 19999, 25, 3),

(5, 'Teclado', 'Teclado mecánico con iluminación RGB', 8999, 30, 2),
(6, 'Mouse', 'Ratón inalámbrico con sensor óptico de alta precisión', 4999, 18, 2),

(7, 'Monitor', 'Pantalla LED 4K de 27 pulgadas', 12999, 12, 3),
(8, 'Impresora', 'Láser multifuncional con Wi-Fi', 14999, 8, 2),

(9, 'Cámara', 'Cámara digital con lente profesional', 79999, 5, 3),
(10, 'Smartwatch', 'Reloj inteligente con GPS y monitoreo cardíaco', 19999, 22, 1),

(11, 'Silla Gamer', 'Silla ergonómica ajustable con soporte lumbar', 29999, 14, 7),

(12, 'Microondas', 'Horno microondas con múltiples funciones', 12999, 10, 4),
(13, 'Refrigerador', 'Refrigerador doble puerta con sistema No Frost', 49999, 6, 4),
(14, 'Lavadora', 'Lavadora automática con capacidad de 10kg', 39999, 7, 4),
(15, 'Cafetera', 'Cafetera espresso con vaporizador de leche', 14999, 9, 4),

(16, 'Drone', 'Drone con cámara 4K y estabilizador', 69999, 3, 3),

(17, 'Bocina Bluetooth', 'Altavoz portátil con sonido envolvente', 9999, 20, 3),
(18, 'Videocámara', 'Videocámara profesional con grabación en 4K', 49999, 4, 3),

(19, 'TV LED', 'Televisor inteligente de 55 pulgadas con HDR', 89999, 11, 3),

(20, 'Batería Externa', 'Batería de 20000mAh con carga rápida', 12999, 45, 2),
(21, 'Disco Duro', 'Disco duro externo de 2TB', 14999, 17, 2),
(22, 'Memoria USB', 'Pendrive de 128GB', 4999, 26, 2),

(23, 'Router', 'Router Wi-Fi 6 de alta velocidad', 9999, 9, 6),
(24, 'Joystick', 'Control inalámbrico para videojuegos', 12999, 13, 7),

(25, 'Fuente de Poder', 'Fuente de alimentación para PC de 750W', 8999, 32, 1),

(26, 'SSD', 'Unidad de almacenamiento SSD de 1TB', 14999, 12, 1),

(27, 'Altavoces', 'Par de bocinas estéreo con subwoofer', 13999, 23, 3),

(28, 'Webcam', 'Cámara web Full HD con micrófono integrado', 6999, 37, 2),

(29, 'Procesador', 'CPU Intel i7 de última generación', 19999, 9, 1),
(30, 'Motherboard', 'Placa base compatible con procesadores modernos', 17999, 14, 1),
(31, 'Memoria RAM', 'Módulo de RAM DDR4 de 16GB', 4999, 41, 1),

(32, 'Fuente Solar', 'Panel solar portátil con batería integrada', 24999, 5, 4),

(33, 'Control Remoto', 'Mando universal para TV y dispositivos', 2499, 30, 2),

(34, 'Termostato', 'Termostato digital programable', 14999, 8, 5),
(35, 'Smart Lock', 'Cerradura electrónica con huella digital', 22999, 6, 5),

(36, 'Proyector', 'Proyector LED con resolución Full HD', 19999, 11, 3),

(37, 'Switch Ethernet', 'Switch de red de 8 puertos', 5999, 38, 6),

(38, 'Reloj Digital', 'Reloj inteligente con pantalla AMOLED', 12999, 20, 1),

(39, 'Luces LED', 'Tiras LED RGB con control remoto', 3599, 55, 5),

(40, 'Estabilizador', 'Estabilizador de voltaje para dispositivos electrónicos', 6999, 16, 2),

(41, 'Cargador Inalámbrico', 'Base de carga inalámbrica rápida', 4999, 12, 2),

(42, 'HDD Externo', 'Disco duro portátil de 4TB', 17999, 15, 1),

(43, 'Micrófono', 'Micrófono profesional para grabación', 12999, 7, 3),

(44, 'Altavoz Inteligente', 'Asistente de voz con altavoz integrado', 12999, 19, 5),

(45, 'Antena Wi-Fi', 'Amplificador de señal inalámbrico', 3999, 32, 6),

(46, 'Climatizador', 'Aire acondicionado portátil con control remoto', 29999, 3, 4),

(47, 'Raspberry Pi', 'Kit de desarrollo con Raspberry Pi 4', 12999, 13, 1),

(48, 'Capturadora', 'Placa de captura de video de alta resolución', 14999, 10, 2),

(49, 'Smart Plug', 'Enchufe inteligente compatible con asistentes virtuales', 3999, 42, 5),

(50, 'Timbre Inteligente', 'Timbre con cámara y conexión a Wi-Fi', 14999, 10, 5)
ON DUPLICATE KEY UPDATE id_producto = id_producto;

INSERT INTO comentarios (id_comentario, id_producto, id_usuario, comentario, fecha) VALUES
(1, 1, 1, 'Excelente rendimiento; muy rápida. ¡Me encanta!', '2025-05-01 00:00:00'),
(2, 2, 2, 'Buena cámara pero la batería dura poco.', '2025-05-03 00:00:00'),
(3, 3, 3, 'No me gustó; pantalla de baja calidad.', '2025-05-05 00:00:00'),
(4, 4, 4, 'Sonido aceptable pero el material parece frágil.', '2025-05-06 00:00:00'),
(5, 5, 5, 'Muy buen teclado mecánico; excelente respuesta.', '2025-05-08 00:00:00'),
(6, 6, 2, 'El sensor no es tan preciso como esperaba.', '2025-05-10 00:00:00'),
(7, 7, 3, 'Colores vibrantes y buena resolución. Muy satisfecho.', '2025-05-12 00:00:00'),
(8, 8, 1, 'Tarda mucho en imprimir; no me convence.', '2025-05-13 00:00:00'),
(9, 9, 4, 'Increíble calidad de imagen; fotos súper nítidas.', '2025-05-15 00:00:00'),
(10, 10, 5, 'Buena batería; pero la pantalla no es muy brillante.', '2025-05-18 00:00:00')
ON DUPLICATE KEY UPDATE id_comentario = id_comentario;
