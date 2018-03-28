java -cp "..\CorrFacturacionMJ1.0\bin" CMain Comandos\comandosMJ1.0.txt >SalidaPractica\SalidaMJ1.0.txt
java -cp "..\CorrFacturacionMJ1.1\bin" CMain Comandos\comandosMJ1.1.txt >SalidaPractica\SalidaMJ1.1.txt
java -cp "..\CorrFacturacionMJ2.0\bin" CMain Comandos\comandosMJ2.0.txt >SalidaPractica\SalidaMJ2.0.txt
java -cp "..\CorrFacturacionMJ3.0\bin" CMain Comandos\comandosMJ3.0.txt >SalidaPractica\SalidaMJ3.0.txt
java -cp "..\CorrFacturacionMJ3.1\bin" CMain Comandos\comandosMJ3.1.txt >SalidaPractica\SalidaMJ3.1.txt
java -cp "..\CorrFacturacionPLA4.0\bin" CMain Comandos\comandosPLA4.0.txt >SalidaPractica\SalidaPLA4.0.txt
java -cp "..\CorrFacturacionPLA4.1\bin" CMain Comandos\comandosPLA4.1.txt >SalidaPractica\SalidaPLA4.1.txt
fc SalidaPractica\SalidaMJ1.0.txt SalidaCorrecta\SalidaMJ1.0.txt
fc SalidaPractica\SalidaMJ1.1.txt SalidaCorrecta\SalidaMJ1.1.txt
fc SalidaPractica\SalidaMJ2.0.txt SalidaCorrecta\SalidaMJ2.0.txt
fc SalidaPractica\SalidaMJ3.0.txt SalidaCorrecta\SalidaMJ3.0.txt
fc SalidaPractica\SalidaMJ3.1.txt SalidaCorrecta\SalidaMJ3.1.txt
fc SalidaPractica\SalidPLA4.0.txt SalidaCorrecta\SalidaPLA4.0.txt
fc SalidaPractica\SalidaPLA4.1.txt SalidaCorrecta\SalidaPLA4.1.txt