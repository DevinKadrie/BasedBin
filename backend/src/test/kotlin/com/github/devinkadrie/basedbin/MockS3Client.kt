package com.github.devinkadrie.basedbin

import aws.sdk.kotlin.services.s3.S3Client
import aws.sdk.kotlin.services.s3.model.*
import java.util.*

val DEFAULT_CONFIG = S3Client.Config.Builder().build()

class MockS3Client : S3Client {
    private val buckets: MutableMap<String, MutableMap<UUID, Paste>> = mutableMapOf()
    override val config: S3Client.Config = DEFAULT_CONFIG

    override suspend fun abortMultipartUpload(
        input: AbortMultipartUploadRequest
    ): AbortMultipartUploadResponse {
        TODO("Not yet implemented")
    }

    override fun close()  = Unit

    override suspend fun completeMultipartUpload(
        input: CompleteMultipartUploadRequest
    ): CompleteMultipartUploadResponse {
        TODO("Not yet implemented")
    }

    override suspend fun copyObject(input: CopyObjectRequest): CopyObjectResponse {
        TODO("Not yet implemented")
    }

    override suspend fun createBucket(input: CreateBucketRequest): CreateBucketResponse {
        TODO("Not yet implemented")
    }

    override suspend fun createMultipartUpload(
        input: CreateMultipartUploadRequest
    ): CreateMultipartUploadResponse {
        TODO("Not yet implemented")
    }

    override suspend fun createSession(input: CreateSessionRequest): CreateSessionResponse {
        TODO("Not yet implemented")
    }

    override suspend fun deleteBucket(input: DeleteBucketRequest): DeleteBucketResponse {
        TODO("Not yet implemented")
    }

    override suspend fun deleteBucketAnalyticsConfiguration(
        input: DeleteBucketAnalyticsConfigurationRequest
    ): DeleteBucketAnalyticsConfigurationResponse {
        TODO("Not yet implemented")
    }

    override suspend fun deleteBucketCors(
        input: DeleteBucketCorsRequest
    ): DeleteBucketCorsResponse {
        TODO("Not yet implemented")
    }

    override suspend fun deleteBucketEncryption(
        input: DeleteBucketEncryptionRequest
    ): DeleteBucketEncryptionResponse {
        TODO("Not yet implemented")
    }

    override suspend fun deleteBucketIntelligentTieringConfiguration(
        input: DeleteBucketIntelligentTieringConfigurationRequest
    ): DeleteBucketIntelligentTieringConfigurationResponse {
        TODO("Not yet implemented")
    }

    override suspend fun deleteBucketInventoryConfiguration(
        input: DeleteBucketInventoryConfigurationRequest
    ): DeleteBucketInventoryConfigurationResponse {
        TODO("Not yet implemented")
    }

    override suspend fun deleteBucketLifecycle(
        input: DeleteBucketLifecycleRequest
    ): DeleteBucketLifecycleResponse {
        TODO("Not yet implemented")
    }

    override suspend fun deleteBucketMetricsConfiguration(
        input: DeleteBucketMetricsConfigurationRequest
    ): DeleteBucketMetricsConfigurationResponse {
        TODO("Not yet implemented")
    }

    override suspend fun deleteBucketOwnershipControls(
        input: DeleteBucketOwnershipControlsRequest
    ): DeleteBucketOwnershipControlsResponse {
        TODO("Not yet implemented")
    }

    override suspend fun deleteBucketPolicy(
        input: DeleteBucketPolicyRequest
    ): DeleteBucketPolicyResponse {
        TODO("Not yet implemented")
    }

    override suspend fun deleteBucketReplication(
        input: DeleteBucketReplicationRequest
    ): DeleteBucketReplicationResponse {
        TODO("Not yet implemented")
    }

    override suspend fun deleteBucketTagging(
        input: DeleteBucketTaggingRequest
    ): DeleteBucketTaggingResponse {
        TODO("Not yet implemented")
    }

    override suspend fun deleteBucketWebsite(
        input: DeleteBucketWebsiteRequest
    ): DeleteBucketWebsiteResponse {
        TODO("Not yet implemented")
    }

    override suspend fun deleteObject(input: DeleteObjectRequest): DeleteObjectResponse {
        TODO("Not yet implemented")
    }

    override suspend fun deleteObjectTagging(
        input: DeleteObjectTaggingRequest
    ): DeleteObjectTaggingResponse {
        TODO("Not yet implemented")
    }

    override suspend fun deleteObjects(input: DeleteObjectsRequest): DeleteObjectsResponse {
        TODO("Not yet implemented")
    }

    override suspend fun deletePublicAccessBlock(
        input: DeletePublicAccessBlockRequest
    ): DeletePublicAccessBlockResponse {
        TODO("Not yet implemented")
    }

    override suspend fun getBucketAccelerateConfiguration(
        input: GetBucketAccelerateConfigurationRequest
    ): GetBucketAccelerateConfigurationResponse {
        TODO("Not yet implemented")
    }

    override suspend fun getBucketAcl(input: GetBucketAclRequest): GetBucketAclResponse {
        TODO("Not yet implemented")
    }

    override suspend fun getBucketAnalyticsConfiguration(
        input: GetBucketAnalyticsConfigurationRequest
    ): GetBucketAnalyticsConfigurationResponse {
        TODO("Not yet implemented")
    }

    override suspend fun getBucketCors(input: GetBucketCorsRequest): GetBucketCorsResponse {
        TODO("Not yet implemented")
    }

    override suspend fun getBucketEncryption(
        input: GetBucketEncryptionRequest
    ): GetBucketEncryptionResponse {
        TODO("Not yet implemented")
    }

    override suspend fun getBucketIntelligentTieringConfiguration(
        input: GetBucketIntelligentTieringConfigurationRequest
    ): GetBucketIntelligentTieringConfigurationResponse {
        TODO("Not yet implemented")
    }

    override suspend fun getBucketInventoryConfiguration(
        input: GetBucketInventoryConfigurationRequest
    ): GetBucketInventoryConfigurationResponse {
        TODO("Not yet implemented")
    }

    override suspend fun getBucketLifecycleConfiguration(
        input: GetBucketLifecycleConfigurationRequest
    ): GetBucketLifecycleConfigurationResponse {
        TODO("Not yet implemented")
    }

    override suspend fun getBucketLocation(
        input: GetBucketLocationRequest
    ): GetBucketLocationResponse {
        TODO("Not yet implemented")
    }

    override suspend fun getBucketLogging(
        input: GetBucketLoggingRequest
    ): GetBucketLoggingResponse {
        TODO("Not yet implemented")
    }

    override suspend fun getBucketMetricsConfiguration(
        input: GetBucketMetricsConfigurationRequest
    ): GetBucketMetricsConfigurationResponse {
        TODO("Not yet implemented")
    }

    override suspend fun getBucketNotificationConfiguration(
        input: GetBucketNotificationConfigurationRequest
    ): GetBucketNotificationConfigurationResponse {
        TODO("Not yet implemented")
    }

    override suspend fun getBucketOwnershipControls(
        input: GetBucketOwnershipControlsRequest
    ): GetBucketOwnershipControlsResponse {
        TODO("Not yet implemented")
    }

    override suspend fun getBucketPolicy(input: GetBucketPolicyRequest): GetBucketPolicyResponse {
        TODO("Not yet implemented")
    }

    override suspend fun getBucketPolicyStatus(
        input: GetBucketPolicyStatusRequest
    ): GetBucketPolicyStatusResponse {
        TODO("Not yet implemented")
    }

    override suspend fun getBucketReplication(
        input: GetBucketReplicationRequest
    ): GetBucketReplicationResponse {
        TODO("Not yet implemented")
    }

    override suspend fun getBucketRequestPayment(
        input: GetBucketRequestPaymentRequest
    ): GetBucketRequestPaymentResponse {
        TODO("Not yet implemented")
    }

    override suspend fun getBucketTagging(
        input: GetBucketTaggingRequest
    ): GetBucketTaggingResponse {
        TODO("Not yet implemented")
    }

    override suspend fun getBucketVersioning(
        input: GetBucketVersioningRequest
    ): GetBucketVersioningResponse {
        TODO("Not yet implemented")
    }

    override suspend fun getBucketWebsite(
        input: GetBucketWebsiteRequest
    ): GetBucketWebsiteResponse {
        TODO("Not yet implemented")
    }

    override suspend fun <T> getObject(
        input: GetObjectRequest,
        block: suspend (GetObjectResponse) -> T,
    ): T {
        TODO("Not yet implemented")
    }

    override suspend fun getObjectAcl(input: GetObjectAclRequest): GetObjectAclResponse {
        TODO("Not yet implemented")
    }

    override suspend fun getObjectAttributes(
        input: GetObjectAttributesRequest
    ): GetObjectAttributesResponse {
        TODO("Not yet implemented")
    }

    override suspend fun getObjectLegalHold(
        input: GetObjectLegalHoldRequest
    ): GetObjectLegalHoldResponse {
        TODO("Not yet implemented")
    }

    override suspend fun getObjectLockConfiguration(
        input: GetObjectLockConfigurationRequest
    ): GetObjectLockConfigurationResponse {
        TODO("Not yet implemented")
    }

    override suspend fun getObjectRetention(
        input: GetObjectRetentionRequest
    ): GetObjectRetentionResponse {
        TODO("Not yet implemented")
    }

    override suspend fun getObjectTagging(
        input: GetObjectTaggingRequest
    ): GetObjectTaggingResponse {
        TODO("Not yet implemented")
    }

    override suspend fun <T> getObjectTorrent(
        input: GetObjectTorrentRequest,
        block: suspend (GetObjectTorrentResponse) -> T,
    ): T {
        TODO("Not yet implemented")
    }

    override suspend fun getPublicAccessBlock(
        input: GetPublicAccessBlockRequest
    ): GetPublicAccessBlockResponse {
        TODO("Not yet implemented")
    }

    override suspend fun headBucket(input: HeadBucketRequest): HeadBucketResponse {
        TODO("Not yet implemented")
    }

    override suspend fun headObject(input: HeadObjectRequest): HeadObjectResponse {
        TODO("Not yet implemented")
    }

    override suspend fun listBucketAnalyticsConfigurations(
        input: ListBucketAnalyticsConfigurationsRequest
    ): ListBucketAnalyticsConfigurationsResponse {
        TODO("Not yet implemented")
    }

    override suspend fun listBucketIntelligentTieringConfigurations(
        input: ListBucketIntelligentTieringConfigurationsRequest
    ): ListBucketIntelligentTieringConfigurationsResponse {
        TODO("Not yet implemented")
    }

    override suspend fun listBucketInventoryConfigurations(
        input: ListBucketInventoryConfigurationsRequest
    ): ListBucketInventoryConfigurationsResponse {
        TODO("Not yet implemented")
    }

    override suspend fun listBucketMetricsConfigurations(
        input: ListBucketMetricsConfigurationsRequest
    ): ListBucketMetricsConfigurationsResponse {
        TODO("Not yet implemented")
    }

    override suspend fun listBuckets(input: ListBucketsRequest): ListBucketsResponse {
        TODO("Not yet implemented")
    }

    override suspend fun listDirectoryBuckets(
        input: ListDirectoryBucketsRequest
    ): ListDirectoryBucketsResponse {
        TODO("Not yet implemented")
    }

    override suspend fun listMultipartUploads(
        input: ListMultipartUploadsRequest
    ): ListMultipartUploadsResponse {
        TODO("Not yet implemented")
    }

    override suspend fun listObjectVersions(
        input: ListObjectVersionsRequest
    ): ListObjectVersionsResponse {
        TODO("Not yet implemented")
    }

    override suspend fun listObjects(input: ListObjectsRequest): ListObjectsResponse {
        TODO("Not yet implemented")
    }

    override suspend fun listObjectsV2(input: ListObjectsV2Request): ListObjectsV2Response {
        TODO("Not yet implemented")
    }

    override suspend fun listParts(input: ListPartsRequest): ListPartsResponse {
        TODO("Not yet implemented")
    }

    override suspend fun putBucketAccelerateConfiguration(
        input: PutBucketAccelerateConfigurationRequest
    ): PutBucketAccelerateConfigurationResponse {
        TODO("Not yet implemented")
    }

    override suspend fun putBucketAcl(input: PutBucketAclRequest): PutBucketAclResponse {
        TODO("Not yet implemented")
    }

    override suspend fun putBucketAnalyticsConfiguration(
        input: PutBucketAnalyticsConfigurationRequest
    ): PutBucketAnalyticsConfigurationResponse {
        TODO("Not yet implemented")
    }

    override suspend fun putBucketCors(input: PutBucketCorsRequest): PutBucketCorsResponse {
        TODO("Not yet implemented")
    }

    override suspend fun putBucketEncryption(
        input: PutBucketEncryptionRequest
    ): PutBucketEncryptionResponse {
        TODO("Not yet implemented")
    }

    override suspend fun putBucketIntelligentTieringConfiguration(
        input: PutBucketIntelligentTieringConfigurationRequest
    ): PutBucketIntelligentTieringConfigurationResponse {
        TODO("Not yet implemented")
    }

    override suspend fun putBucketInventoryConfiguration(
        input: PutBucketInventoryConfigurationRequest
    ): PutBucketInventoryConfigurationResponse {
        TODO("Not yet implemented")
    }

    override suspend fun putBucketLifecycleConfiguration(
        input: PutBucketLifecycleConfigurationRequest
    ): PutBucketLifecycleConfigurationResponse {
        TODO("Not yet implemented")
    }

    override suspend fun putBucketLogging(
        input: PutBucketLoggingRequest
    ): PutBucketLoggingResponse {
        TODO("Not yet implemented")
    }

    override suspend fun putBucketMetricsConfiguration(
        input: PutBucketMetricsConfigurationRequest
    ): PutBucketMetricsConfigurationResponse {
        TODO("Not yet implemented")
    }

    override suspend fun putBucketNotificationConfiguration(
        input: PutBucketNotificationConfigurationRequest
    ): PutBucketNotificationConfigurationResponse {
        TODO("Not yet implemented")
    }

    override suspend fun putBucketOwnershipControls(
        input: PutBucketOwnershipControlsRequest
    ): PutBucketOwnershipControlsResponse {
        TODO("Not yet implemented")
    }

    override suspend fun putBucketPolicy(input: PutBucketPolicyRequest): PutBucketPolicyResponse {
        TODO("Not yet implemented")
    }

    override suspend fun putBucketReplication(
        input: PutBucketReplicationRequest
    ): PutBucketReplicationResponse {
        TODO("Not yet implemented")
    }

    override suspend fun putBucketRequestPayment(
        input: PutBucketRequestPaymentRequest
    ): PutBucketRequestPaymentResponse {
        TODO("Not yet implemented")
    }

    override suspend fun putBucketTagging(
        input: PutBucketTaggingRequest
    ): PutBucketTaggingResponse {
        TODO("Not yet implemented")
    }

    override suspend fun putBucketVersioning(
        input: PutBucketVersioningRequest
    ): PutBucketVersioningResponse {
        TODO("Not yet implemented")
    }

    override suspend fun putBucketWebsite(
        input: PutBucketWebsiteRequest
    ): PutBucketWebsiteResponse {
        TODO("Not yet implemented")
    }

    override suspend fun putObject(input: PutObjectRequest): PutObjectResponse {
        TODO("Not yet implemented")
    }

    override suspend fun putObjectAcl(input: PutObjectAclRequest): PutObjectAclResponse {
        TODO("Not yet implemented")
    }

    override suspend fun putObjectLegalHold(
        input: PutObjectLegalHoldRequest
    ): PutObjectLegalHoldResponse {
        TODO("Not yet implemented")
    }

    override suspend fun putObjectLockConfiguration(
        input: PutObjectLockConfigurationRequest
    ): PutObjectLockConfigurationResponse {
        TODO("Not yet implemented")
    }

    override suspend fun putObjectRetention(
        input: PutObjectRetentionRequest
    ): PutObjectRetentionResponse {
        TODO("Not yet implemented")
    }

    override suspend fun putObjectTagging(
        input: PutObjectTaggingRequest
    ): PutObjectTaggingResponse {
        TODO("Not yet implemented")
    }

    override suspend fun putPublicAccessBlock(
        input: PutPublicAccessBlockRequest
    ): PutPublicAccessBlockResponse {
        TODO("Not yet implemented")
    }

    override suspend fun restoreObject(input: RestoreObjectRequest): RestoreObjectResponse {
        TODO("Not yet implemented")
    }

    override suspend fun <T> selectObjectContent(
        input: SelectObjectContentRequest,
        block: suspend (SelectObjectContentResponse) -> T,
    ): T {
        TODO("Not yet implemented")
    }

    override suspend fun uploadPart(input: UploadPartRequest): UploadPartResponse {
        TODO("Not yet implemented")
    }

    override suspend fun uploadPartCopy(input: UploadPartCopyRequest): UploadPartCopyResponse {
        TODO("Not yet implemented")
    }

    override suspend fun writeGetObjectResponse(
        input: WriteGetObjectResponseRequest
    ): WriteGetObjectResponseResponse {
        TODO("Not yet implemented")
    }
}
