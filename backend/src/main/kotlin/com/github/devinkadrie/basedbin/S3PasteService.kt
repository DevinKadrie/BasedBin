package com.github.devinkadrie.basedbin

import aws.sdk.kotlin.services.s3.S3Client
import aws.sdk.kotlin.services.s3.model.CreateBucketRequest
import aws.sdk.kotlin.services.s3.model.GetObjectRequest
import aws.sdk.kotlin.services.s3.model.PutObjectRequest
import aws.smithy.kotlin.runtime.content.ByteStream
import aws.smithy.kotlin.runtime.content.decodeToString
import java.util.UUID
import kotlinx.coroutines.*

class S3PasteService(private val client: S3Client) : PasteService {
    private var initialized = false

    private suspend fun maybeInit() {
        if (initialized) return
        val request = CreateBucketRequest { bucket = "Pastes" }
        val listBucketsResponse = client.listBuckets()
        val bucket = listBucketsResponse.buckets?.find { it.name == "Pastes" }
        if (bucket == null) {
            client.createBucket(request)
            initialized = true
        }
        return
    }

    override suspend fun create(paste: Paste): UUID? =
        withContext(Dispatchers.IO) {
            maybeInit()
            val s3Key = UUID.randomUUID()
            val request = PutObjectRequest {
                bucket = "pastes"
                key = s3Key.toString()
                this.body = ByteStream.fromString(paste.content)
            }
            try {
                client.putObject(request)
                return@withContext s3Key
            } catch (e: Exception) {
                return@withContext null
            }
        }

    override suspend fun read(id: UUID) =
        withContext(Dispatchers.IO) {
            maybeInit()
            val request = GetObjectRequest {
                bucket = "pastes"
                key = id.toString()
            }

            client.getObject(request) { it.body?.decodeToString()?.let(::Paste) }
        }
}
