# 🛒 Sistema de Facturación - Market Distributed

Trabajo Práctico Obligatorio de **Paradigma Orientado a Objetos** (1C 2025)  
Autor: **Guillermo Hernandez**

---

## 📌 Descripción

Este proyecto implementa un sistema de facturación para la empresa ficticia **Market Distributed**, la cual cuenta con minimercados distribuidos en la Ciudad de Buenos Aires.  

El objetivo del software es permitir la gestión del catálogo de productos y el registro de ventas, aplicando los conceptos del **paradigma de Programación Orientada a Objetos en Java**.

---

## ⚙️ Funcionalidades

✔️ Manejo de un catálogo de productos:
- Código, descripción, precio unitario, cantidad en stock y stock mínimo.
- Carga y visualización del listado de productos.

✔️ Registro de ventas con diferentes medios de pago:
- **Débito** → Se cobra el valor total.  
- **Efectivo** → 10% de descuento.  
- **Crédito** → Recargos según cuotas:  
  - 2 cuotas → +6%  
  - 3 cuotas → +12%  
  - 6 cuotas → +20%

✔️ Control de stock:
- Disminuye automáticamente con cada venta.  
- Notificación de stock insuficiente.  
- Marcado de productos con stock mínimo.  

✔️ Implementación con interfaz **consola** (posibilidad de expansión a GUI).  

✔️ Tests unitarios con **JUnit**.  

---

## 🏗️ Estructura del proyecto

