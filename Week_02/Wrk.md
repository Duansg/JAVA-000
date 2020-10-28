### 一、串行GC

-  **-Xms128m -Xmx128m**：RPS: 7942.2 (requests/second) Max: 174ms Min: 0ms Avg: 0.1ms
-  **-Xms512m -Xmx512m**：RPS: 7963.2 (requests/second) Max: 128ms Min: 0ms Avg: 0.1ms
-  **-Xms1g -Xmx1g**：RPS: 7936.3 (requests/second) Max: 123ms Min: 0ms Avg: 0ms
- **-Xms4g -Xmx4g**：RPS: 7914.8 (requests/second) Max: 127ms Min: 0ms Avg: 0.1ms

### 二、并行GC

- **-Xms128m -Xmx128m**：RPS: 7982.7 (requests/second) Max: 135ms Min: 0ms Avg: 0.1ms
- **-Xms512m -Xmx512m**：RPS: 7975 (requests/second) Max: 186ms Min: 0ms Avg: 0.1ms
- **-Xms1g -Xmx1g**：RPS: 8075.3 (requests/second) Max: 38ms Min: 0ms Avg: 0ms
- **-Xms4g -Xmx4g**：RPS: 8027.5 (requests/second) Max: 130ms Min: 0ms Avg: 0ms

### 三、CMS GC

- **-Xms128m -Xmx128m**：RPS: 7814.8 (requests/second) Max: 128ms Min: 0ms Avg: 0.1ms
- **-Xms512m -Xmx512m**：RPS: 7898 (requests/second) Max: 137ms Min: 0ms Avg: 0ms
- **-Xms1g -Xmx1g**：RPS: 7982.7 (requests/second) Max: 123ms Min: 0ms Avg: 0.1ms
- **-Xms4g -Xmx4g**：RPS: 7979.7 (requests/second) Max: 128ms Min: 0ms Avg: 0.1ms

### 四、G1 GC

- **-Xms128m -Xmx128m**：RPS: 8077.8 (requests/second) Max: 149ms Min: 0ms Avg: 0ms
- **-Xms512m -Xmx512m**：RPS: 7977.1 (requests/second) Max: 150ms Min: 0ms Avg: 0.1ms
- **-Xms1g -Xmx1g**：RPS: 7937.5 (requests/second) Max: 148ms Min: 0ms Avg: 0.1ms
- **-Xms4g -Xmx4g**：RPS: 7930.9 (requests/second) Max: 154ms Min: 0ms Avg: 0.1ms

### 五、结论

由上可得出，更换回收算法相对于20并发来说都差不多，RPS都在8000上下。相对来说堆空间较大时，G1GC要优于串行的。