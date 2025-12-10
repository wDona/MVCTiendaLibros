import csv
import json

with open("../resources/ventas.json", "r") as ventas:
    datos_ventas = json.load(ventas)

print(datos_ventas)
print(type(datos_ventas))

with open("../resources/salidapython.csv", "w", newline="") as salidapython:
    writer = csv.writer(salidapython)
    # Escribe el isbn y las ud vendidas    
    for venta in datos_ventas["venta"]:
        for libro in venta["libros"]:
            writer.writerow([libro["id"], libro["cantidadVendida"]])