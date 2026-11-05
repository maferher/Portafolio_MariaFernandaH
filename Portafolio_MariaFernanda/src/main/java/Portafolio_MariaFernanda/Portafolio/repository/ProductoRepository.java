/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package Portafolio_MariaFernanda.Portafolio.repository;

import Portafolio_MariaFernanda.Portafolio.domain.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer>{
    public List<Producto> findByActivoTrue();

    // 1. Derivada
    public List<Producto> findByPrecioBetweenOrderByPrecioAsc(
            BigDecimal precioInf, BigDecimal precioSup);

    // 2. JPQL
    @Query(value = "SELECT p FROM Producto p "
            + "WHERE p.precio BETWEEN :precioInf AND :precioSup "
            + "ORDER BY p.precio ASC")
    public List<Producto> consultaJPQL(
            BigDecimal precioInf, BigDecimal precioSup);

    // 3. SQL nativo
    @Query(nativeQuery = true,
            value = "SELECT * FROM producto p "
            + "WHERE p.precio BETWEEN :precioInf AND :precioSup "
            + "ORDER BY p.precio ASC")
    public List<Producto> consultaSQL(
            BigDecimal precioInf, BigDecimal precioSup);
    
    //Tarea 2
    @Query(value = "SELECT p FROM Producto p "
            + "WHERE LOWER(p.descripcion) LIKE LOWER(CONCAT('%', :palabra, '%')) "
            + "AND p.existencias >= :existenciasMin "
            + "ORDER BY p.descripcion ASC")
    public List<Producto> consultaPractica2(
            String palabra, Integer existenciasMin);
}