package com.examplo.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.exemplo.forum.model.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
}
