package com.learning.ollama.controller;

import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.ollama.service.LlamaAiService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path = "api/v1/ollama")
@RequiredArgsConstructor
public class OllamaController {

    private final LlamaAiService llamaAiService;

    /**
     * Accepts a prompt and returns a single response generated by LLaMA 3.
     *
     * @param payLoad Payload with Prompt
     * @return response
     */
    @PostMapping(path = "/ai/ask",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> processThePrompt(@RequestBody Map<String, String> payLoad) {
        logger.info("prompt:: {} to Llama3 model ", payLoad.get("prompt"));
        return ResponseEntity.ok(
                Map.of("chatResponse",
                        llamaAiService.processThePrompt(payLoad.getOrDefault("prompt", "What can you do for me?"))
                ));

    }
}
