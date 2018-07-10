org.springframework.cloud.contract.spec.Contract.make {
    request {
        method 'PUT'
        url '/check/fraudcheck'
        body("""
        {
          "clientId":"1234567890",
          "loanAmount":99999
        }
        """)
        headers {
            header('Content-Type', 'application/json')
        }
    }
    response {
        status 200
        body("""
        {
          "fraudCheckStatus": "FRAUD",
          "rejectionReason": "Amount too high"
        }
        """)
        headers {
            header('Content-Type': 'application/json')
        }
    }
}