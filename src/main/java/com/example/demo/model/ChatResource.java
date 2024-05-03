package com.example.demo.model;


import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
@Data
public class ChatResource {

    private String totalChat = "";
}
