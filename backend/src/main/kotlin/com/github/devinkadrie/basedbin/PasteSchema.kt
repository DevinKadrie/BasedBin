package com.github.devinkadrie.basedbin

import aws.sdk.kotlin.services.s3.S3Client
import aws.sdk.kotlin.services.s3.model.ChecksumAlgorithm
import aws.sdk.kotlin.services.s3.model.GetObjectRequest
import aws.sdk.kotlin.services.s3.model.PutObjectRequest
import aws.smithy.kotlin.runtime.content.ByteStream
import aws.smithy.kotlin.runtime.content.asByteStream
import aws.smithy.kotlin.runtime.content.writeToOutputStream
import aws.smithy.kotlin.runtime.http.toHttpBody
import kotlinx.coroutines.*
import kotlinx.serialization.Serializable
import java.io.InputStream
import java.io.OutputStream
import java.util.UUID

@Serializable
data class Paste(val content: String)

class PasteService(private val client: S3Client) {
    init {
        // TODO: Create bucket if it does not exist.
    }

    suspend fun create(paste: Paste): UUID = withContext(Dispatchers.IO) {
        val s3Key = UUID.randomUUID()
        val request = PutObjectRequest {
            bucket = "pastes"
            key = s3Key.toString()
            this.body = ByteStream.fromString(paste.content)
        }

        val response = client.putObject(request)
        // TODO: Handle response

        return@withContext s3Key
    }

    suspend fun read(id: UUID, output: OutputStream) = withContext(Dispatchers.IO) {
        val request = GetObjectRequest {
            bucket = "pastes"
            key = id.toString()
        }
        // TODO: Null
        client.getObject(request) { it.body?.writeToOutputStream(output) }
    }
}

