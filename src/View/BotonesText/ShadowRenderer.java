package View.BotonesText;

import View.BotonesText.GraphicsUtilities;
import java.awt.Color;
import java.awt.image.BufferedImage;

public class ShadowRenderer {

    /* Propiedades para el sombreado */
    private int size = 5; /* Tamaño del sombreado */
    private float opacity = 0.5f; /* Opacidad del sombreado */
    private Color color = Color.BLACK; /* Color del sombreado */

    // Constructor predeterminado
    public ShadowRenderer() {
        /* Llama al constructor con parámetros usando valores predeterminados */
        this(5, 0.5f, Color.BLACK);
    }

    // Constructor con parámetros
    public ShadowRenderer(final int size, final float opacity, final Color color) {
        this.size = size;
        this.opacity = opacity;
        this.color = color;
    }

    // Obtener el color del sombreado
    public Color getColor() {
        return color;
    }

    // Obtener la opacidad del sombreado
    public float getOpacity() {
        return opacity;
    }

    // Obtener el tamaño del sombreado
    public int getSize() {
        return size;
    }

    // Método para crear una imagen con efecto de sombra a partir de una imagen dada
    public BufferedImage createShadow(final BufferedImage image) {
        // Tamaño del sombreado
        int shadowSize = size * 2;
        // Dimensiones de la imagen de origen
        int srcWidth = image.getWidth();
        int srcHeight = image.getHeight();
        // Dimensiones de la imagen de destino con sombreado
        int dstWidth = srcWidth + shadowSize;
        int dstHeight = srcHeight + shadowSize;
        // Posiciones de la sombra izquierda y derecha
        int left = size;
        int right = shadowSize - left;
        // Límite superior para el efecto de sombra
        int yStop = dstHeight - right;
        // Color de sombra sin canal alfa
        int shadowRgb = color.getRGB() & 0x00FFFFFF;
        int[] aHistory = new int[shadowSize];
        int historyIdx;
        int aSum;
        // Imagen de destino con sombra
        BufferedImage dst = new BufferedImage(dstWidth, dstHeight,
                BufferedImage.TYPE_INT_ARGB);
        int[] dstBuffer = new int[dstWidth * dstHeight];
        int[] srcBuffer = new int[srcWidth * srcHeight];
        // Obtener píxeles de la imagen original
        GraphicsUtilities.getPixels(image, 0, 0, srcWidth, srcHeight, srcBuffer);
        int lastPixelOffset = right * dstWidth;
        float hSumDivider = 1.0f / shadowSize;
        float vSumDivider = opacity / shadowSize;
        int[] hSumLookup = new int[256 * shadowSize];
        for (int i = 0; i < hSumLookup.length; i++) {
            hSumLookup[i] = (int) (i * hSumDivider);
        }
        int[] vSumLookup = new int[256 * shadowSize];
        for (int i = 0; i < vSumLookup.length; i++) {
            vSumLookup[i] = (int) (i * vSumDivider);
        }
        int srcOffset;
        // Procesamiento de píxeles para aplicar el efecto de sombra
        for (int srcY = 0, dstOffset = left * dstWidth; srcY < srcHeight; srcY++) {
            for (historyIdx = 0; historyIdx < shadowSize;) {
                aHistory[historyIdx++] = 0;
            }
            aSum = 0;
            historyIdx = 0;
            srcOffset = srcY * srcWidth;
            for (int srcX = 0; srcX < srcWidth; srcX++) {
                int a = hSumLookup[aSum];
                dstBuffer[dstOffset++] = a << 24;
                aSum -= aHistory[historyIdx];
                a = srcBuffer[srcOffset + srcX] >>> 24;
                aHistory[historyIdx] = a;
                aSum += a;
                if (++historyIdx >= shadowSize) {
                    historyIdx -= shadowSize;
                }
            }
            for (int i = 0; i < shadowSize; i++) {
                int a = hSumLookup[aSum];
                dstBuffer[dstOffset++] = a << 24;
                aSum -= aHistory[historyIdx];
                if (++historyIdx >= shadowSize) {
                    historyIdx -= shadowSize;
                }
            }
        }

        for (int x = 0, bufferOffset = 0; x < dstWidth; x++, bufferOffset = x) {
            aSum = 0;
            for (historyIdx = 0; historyIdx < left;) {
                aHistory[historyIdx++] = 0;
            }
            for (int y = 0; y < right; y++, bufferOffset += dstWidth) {
                int a = dstBuffer[bufferOffset] >>> 24;
                aHistory[historyIdx++] = a;
                aSum += a;
            }
            bufferOffset = x;
            historyIdx = 0;
            for (int y = 0; y < yStop; y++, bufferOffset += dstWidth) {
                int a = vSumLookup[aSum];
                dstBuffer[bufferOffset] = a << 24 | shadowRgb;
                aSum -= aHistory[historyIdx];
                a = dstBuffer[bufferOffset + lastPixelOffset] >>> 24;
                aHistory[historyIdx] = a;
                aSum += a;
                if (++historyIdx >= shadowSize) {
                    historyIdx -= shadowSize;
                }
            }
            for (int y = yStop; y < dstHeight; y++, bufferOffset += dstWidth) {
                int a = vSumLookup[aSum];
                dstBuffer[bufferOffset] = a << 24 | shadowRgb;
                aSum -= aHistory[historyIdx];
                if (++historyIdx >= shadowSize) {
                    historyIdx -= shadowSize;
                }
            }
        }
        // Configurar píxeles en la imagen de destino con sombra
        GraphicsUtilities.setPixels(dst, 0, 0, dstWidth, dstHeight, dstBuffer);
        return dst;
    }
}
