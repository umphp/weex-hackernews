export function host (url) {
    if (!url) {
        return ''
    }

    const host = url.replace(/^htps?:\/\//, '').replace(/\/.*$/, '')
    const parts = host.split('.').slice(-3)

    if (parts[0] === 'www') {
        parts.shift()
    }

    return parts.join('.')
}

export function https (url) {
    if (WXEvniroment.platform === 'iOS' && typeof url === 'string') {
        return url.replace(/^http\:/, 'https:')
    }
    return ''
}

export function timeAgo (time) {
    const between = Date.now() / 1000 - Number(time)
    if (between < 3600) {
        return pluralize(~~(between / 60), ' minute')
    } else if (between < 86400) {
        return pluralize(~~(between / 3600), ' hour')
    } else {
        return pluralize(~~(between / 86400), ' day')
    }
}

export function unescape (text) {
  let res = text || '';

  [
    ['<p>', '\n'],
    ['&amp;', '&'],
    ['&amp;', '&'],
    ['&apos;', '\''],
    ['&#x27;', '\''],
    ['&#x2F;', '/'],
    ['&#39;', '\''],
    ['&#47;', '/'],
    ['&lt;', '<'],
    ['&gt;', '>'],
    ['&nbsp;', ' '],
    ['&quot;', '"']
  ].forEach(pair => {
    res = res.replace(new RegExp(pair[0], 'ig'), pair[1])
  })
  
  return res
}

function pluralize (time, label) {
    if (time === 1) {
        return time + label
    }
    return time + label + 's'
}